package dmitriykhalturin.postreader.repository.mapper

import dmitriykhalturin.postreader.database.entity.CommentEntity
import dmitriykhalturin.postreader.database.entity.PostEntity
import dmitriykhalturin.postreader.model.Comment
import dmitriykhalturin.postreader.model.Post

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 01.09.19 0:16.
 */
object DataMapper {
  @JvmStatic
  fun transform(data: Post) =
    PostEntity(
      data.userId,
      data.id,
      data.title,
      data.body
    )

  @JvmStatic
  fun transformPostList(list: List<Post>): List<PostEntity> = list.map {
    transform(it)
  }

  @JvmStatic
  fun transform(data: PostEntity) =
    Post(
      data.userId,
      data.id,
      data.title,
      data.body
    )

  @JvmStatic
  fun transformPostEntityList(list: List<PostEntity>): List<Post> = list.map {
    transform(it)
  }

  @JvmStatic
  fun transform(data: Comment) =
    CommentEntity(
      data.postId,
      data.id,
      data.name,
      data.email,
      data.body
    )

  @JvmStatic
  fun transformCommentList(list: List<Comment>): List<CommentEntity> = list.map {
    transform(it)
  }

  @JvmStatic
  fun transform(data: CommentEntity) =
    Comment(
      data.postId,
      data.id,
      data.name,
      data.email,
      data.body
    )

  @JvmStatic
  fun transformCommentEntityList(list: List<CommentEntity>): List<Comment> = list.map {
    transform(it)
  }
}
