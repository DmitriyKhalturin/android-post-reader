package dmitriykhalturin.postreader.database.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 11:07.
 */
class PostWithCommentsEntity {
  @Embedded
  lateinit var post: PostEntity

  @Relation(parentColumn = "id", entityColumn = "postId")
  lateinit var comments: List<CommentEntity>
}
