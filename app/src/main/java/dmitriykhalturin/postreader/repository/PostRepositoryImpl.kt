package dmitriykhalturin.postreader.repository

import android.annotation.SuppressLint
import dmitriykhalturin.postreader.api.ApiClient
import dmitriykhalturin.postreader.database.DBClient
import dmitriykhalturin.postreader.database.entity.PostWithCommentsEntity
import dmitriykhalturin.postreader.exception.EmptyCacheException
import dmitriykhalturin.postreader.model.Post
import dmitriykhalturin.postreader.model.PostWithComments
import dmitriykhalturin.postreader.repository.mapper.DataMapper
import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 31.08.19 23:55.
 */
class PostRepositoryImpl @Inject constructor(
  private val apiClient: ApiClient,
  private val dbClient: DBClient
) : PostRepository {
  override fun getPosts() = buildSingle<List<Post>> { emitter ->
    val postDao = dbClient.instance.postDao()

    apiClient.apiService.getPosts().subscribe({
      postDao.addPosts(
        DataMapper.transformPostList(it)
      )

      emitter.onSuccess(it)
    }, {
      val posts = postDao.getPosts()

      if (posts.isNotEmpty()) {
        emitter.onSuccess(
          DataMapper.transformPostEntityList(posts)
        )
      } else {
        emitter.onError(EmptyCacheException())
      }
    })
  }

  override fun getPost(postId: Int) = buildSingle<PostWithComments> { emitter ->
    val postDao = dbClient.instance.postDao()

    apiClient.apiService.getPost(postId)
      .subscribe({
        postDao.addPost(
          DataMapper.transform(it)
        )

        getCommentsFromPost(emitter, it)
      }, {
        val postWithComments = postDao.getPostWithComments(postId)

        if (postWithComments is PostWithCommentsEntity) {
          emitter.onSuccess(
            PostWithComments(
              DataMapper.transform(postWithComments.post),
              DataMapper.transformCommentEntityList(
                postWithComments.comments
              )
            )
          )
        } else {
          emitter.onError(EmptyCacheException())
        }
      })
  }

  @SuppressLint(value = ["CheckResult"])
  private fun getCommentsFromPost(emitter: SingleEmitter<PostWithComments>, post: Post) {
    val commentDao = dbClient.instance.commentDao()

    apiClient.apiService.getCommentsByPost(post.id).subscribe({
      commentDao.addComments(
        DataMapper.transformCommentList(it)
      )

      emitter.onSuccess(
        PostWithComments(post, it)
      )
    }, {
      emitter.onSuccess(
        PostWithComments(
          post,
          DataMapper.transformCommentEntityList(
            commentDao.getComments(post.id)
          )
        )
      )
    })
  }

  private fun <T> buildSingle(callback: (emitter: SingleEmitter<T>) -> Unit) =
    Single.create<T>(callback)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
}
