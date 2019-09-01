package dmitriykhalturin.postreader.viewmodel

import android.app.Activity
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.LinearLayoutManager
import dmitriykhalturin.postreader.PostReaderApplication
import dmitriykhalturin.postreader.adapter.CommentsAdapter
import dmitriykhalturin.postreader.binding.RecyclerViewManager
import dmitriykhalturin.postreader.model.Post
import dmitriykhalturin.postreader.repository.PostRepository
import javax.inject.Inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 29.08.19 23:52.
 */
class PostDetailViewModel : BaseViewModel() {

  init {
    PostReaderApplication
      .injector
      .applicationComponent
      .inject(this)
  }

  @Inject lateinit var repository: PostRepository

  val isLoading = ObservableBoolean()
  val post = ObservableField<Post>()
  val listManager = ObservableField<RecyclerViewManager<CommentsAdapter>>()

  private val commentsAdapter = CommentsAdapter()

  fun initViewModel(activity: Activity, postId: Int) {
    listManager.set(
      RecyclerViewManager(
        LinearLayoutManager(activity),
        commentsAdapter
      )
    )

    if (post.get() !is Post) {
      isLoading.set(true)

      disposable = repository
        .getPost(postId)
        .subscribe({ postWithComments ->
          post.set(postWithComments.post)
          commentsAdapter.items = postWithComments.comments

          isLoading.set(false)
        }, {
          // TODO: show error message
          isLoading.set(false)
        })
    }
  }
}
