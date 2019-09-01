package dmitriykhalturin.postreader.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 22:14.
 */
object RecyclerViewAttribute {
  @JvmStatic
  @BindingAdapter(value = ["recyclerViewManager"])
  fun bindRecyclerViewAdapter(recyclerView: RecyclerView, recyclerViewManager: RecyclerViewManager<*>?) {
    if (recyclerViewManager is RecyclerViewManager) {
      recyclerView.layoutManager = recyclerViewManager.layoutManager
      recyclerView.adapter = recyclerViewManager.adapter
    }
  }
}
