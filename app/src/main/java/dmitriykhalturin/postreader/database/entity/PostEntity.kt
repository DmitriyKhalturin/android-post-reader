package dmitriykhalturin.postreader.database.entity

import androidx.room.Entity

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 0:45.
 */
@Entity(
  tableName = "post",
  primaryKeys = ["id"]
)
data class PostEntity(
  val userId: Int,
  val id: Int,
  val title: String,
  val body: String
)
