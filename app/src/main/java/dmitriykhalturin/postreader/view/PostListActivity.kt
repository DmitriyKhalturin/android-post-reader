package dmitriykhalturin.postreader.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.reader.post.R
import com.reader.post.databinding.ActivityPostListBinding
import dmitriykhalturin.postreader.viewmodel.PostListViewModel

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 29.08.19 23:47.
 */
class PostListActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil
      .setContentView<ActivityPostListBinding>(this, R.layout.activity_post_list)

    val postListViewModel = ViewModelProviders
      .of(this)
      .get(PostListViewModel::class.java)

    binding.postList = postListViewModel

    postListViewModel.initViewModel(this)
  }
}
