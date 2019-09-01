package dmitriykhalturin.postreader.database

import android.content.Context
import javax.inject.Inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 0:40.
 */
class DBClient @Inject constructor(private val context: Context) {
  val instance: SQLiteDatabase by lazy {
    SQLiteDatabase.getInstance(context)
  }
}
