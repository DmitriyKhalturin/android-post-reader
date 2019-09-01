package dmitriykhalturin.postreader.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 0:45.
 */
@Entity(
  tableName = "comment",
  primaryKeys = ["id"],
  indices = [
    Index(
      value = ["postId"]
    )
  ],
  foreignKeys = [
    ForeignKey(
      entity = PostEntity::class,
      parentColumns = ["id"],
      childColumns = ["postId"]
    )
  ]
)
data class CommentEntity(
  val postId: Int,
  val id: Int,
  val name: String,
  val email: String,
  val body: String
)
