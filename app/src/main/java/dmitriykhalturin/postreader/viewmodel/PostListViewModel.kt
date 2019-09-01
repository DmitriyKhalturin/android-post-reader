package dmitriykhalturin.postreader.viewmodel

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.LinearLayoutManager
import dmitriykhalturin.postreader.PostReaderApplication
import dmitriykhalturin.postreader.adapter.PostsAdapter
import dmitriykhalturin.postreader.binding.RecyclerViewManager
import dmitriykhalturin.postreader.repository.PostRepository
import dmitriykhalturin.postreader.view.PostDetailActivity
import javax.inject.Inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 29.08.19 23:52.
 */
class PostListViewModel : BaseViewModel() {

  init {
    PostReaderApplication
      .injector
      .applicationComponent
      .inject(this)
  }

  @Inject lateinit var repository: PostRepository

  val isLoading = ObservableBoolean()
  val listManager = ObservableField<RecyclerViewManager<PostsAdapter>>()

  private val postsAdapter = PostsAdapter()

  fun initViewModel(activity: Activity) {
    postsAdapter.setOnPostClickListener {
      openPost(activity, it)
    }

    listManager.set(
      RecyclerViewManager(
        LinearLayoutManager(activity),
        postsAdapter
      )
    )

    if (postsAdapter.itemCount == 0) {
      loadPosts()
    }
  }

  fun loadPosts() {
    isLoading.set(true)

    disposable = repository
      .getPosts()
      .subscribe({ list ->
        postsAdapter.items = list

        isLoading.set(false)
      }, {
        // TODO: show error message
        isLoading.set(false)
      })
  }

  private fun openPost(activity: Activity, postId: Int) {
    activity.startActivity(
      Intent(activity, PostDetailActivity::class.java).apply {
        putExtras(
          Bundle().apply {
            putInt(PostDetailActivity.POST_ID, postId)
          }
        )
      }
    )
  }
}
