package dmitriykhalturin.postreader.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dmitriykhalturin.postreader.model.Post
import kotlinx.android.synthetic.main.layout_post.view.*

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 22:20.
 */
class PostViewHolder(
  view: View,
  private val onPostClickListener: OnPostClickListener
) : RecyclerView.ViewHolder(view) {

  private val title = view.title
  private val body = view.body

  private val post = view.post
  private var id: Int? = null

  init {
    post.setOnClickListener {
      id?.let { postId ->
        onPostClickListener(postId)
      }
    }
  }

  fun bind(data: Post) {
    title.text = data.title
    body.text = data.body

    id = data.id
  }
}
