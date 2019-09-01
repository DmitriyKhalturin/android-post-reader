package dmitriykhalturin.postreader.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dmitriykhalturin.postreader.model.Comment
import kotlinx.android.synthetic.main.layout_comment.view.*

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 01.09.19 13:01.
 */
class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

  private val name = view.name
  private val email = view.email
  private val body = view.body

  fun bind(comment: Comment) {
    name.text = comment.name
    email.text = comment.email
    body.text = comment.body
  }
}
