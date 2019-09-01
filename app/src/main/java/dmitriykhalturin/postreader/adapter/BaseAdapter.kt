package dmitriykhalturin.postreader.adapter

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 01.09.19 13:08.
 */
abstract class BaseAdapter<T, VH: RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

  protected val dataSet = arrayListOf<T>()

  var items: List<T>
    get() = dataSet
    set(value) {
      dataSet.clear()
      dataSet.addAll(value)

      notifyDataSetChanged()
    }

  override fun getItemCount() = dataSet.size
}
