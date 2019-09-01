package dmitriykhalturin.postreader.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.reader.post.R
import dmitriykhalturin.postreader.model.Post

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 22:19.
 */
class PostsAdapter : BaseAdapter<Post, PostViewHolder>() {

  private lateinit var onPostClickListener: OnPostClickListener

  fun setOnPostClickListener(listener: OnPostClickListener) {
    onPostClickListener = listener
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.layout_post, parent, false)

    return PostViewHolder(view, onPostClickListener)
  }

  override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
    holder.bind(dataSet[position])
  }
}
