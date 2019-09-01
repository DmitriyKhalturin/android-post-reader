package dmitriykhalturin.postreader.binding

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 23:10.
 */
data class RecyclerViewManager<A: RecyclerView.Adapter<*>>(
  val layoutManager: RecyclerView.LayoutManager,
  val adapter: A
)
