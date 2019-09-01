package dmitriykhalturin.postreader.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.reader.post.R
import dmitriykhalturin.postreader.model.Comment

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 01.09.19 13:03.
 */
class CommentsAdapter : BaseAdapter<Comment, CommentViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.layout_comment, parent, false)

    return CommentViewHolder(view)
  }

  override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
    holder.bind(dataSet[position])
  }
}
