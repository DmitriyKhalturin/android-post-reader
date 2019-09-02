package dmitriykhalturin.postreader.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import dmitriykhalturin.postreader.R
import dmitriykhalturin.postreader.databinding.ActivityPostDetailBinding
import dmitriykhalturin.postreader.viewmodel.PostDetailViewModel

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 29.08.19 23:47.
 */
class PostDetailActivity : AppCompatActivity() {

  companion object {
    const val POST_ID = "POST_ID"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil
      .setContentView<ActivityPostDetailBinding>(this, R.layout.activity_post_detail)

    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    val postDetailViewModel = ViewModelProviders
      .of(this)
      .get(PostDetailViewModel::class.java)

    binding.postDetail = postDetailViewModel

    intent?.extras?.getInt(POST_ID)?.let {
      postDetailViewModel.initViewModel(this, it)
    }
  }

  override fun onOptionsItemSelected(item: MenuItem?) = when(item?.itemId) {
    android.R.id.home -> {
      finish()
      true
    }
    else -> super.onOptionsItemSelected(item)
  }
}
