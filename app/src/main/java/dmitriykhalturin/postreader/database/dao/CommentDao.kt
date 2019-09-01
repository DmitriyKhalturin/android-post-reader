package dmitriykhalturin.postreader.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dmitriykhalturin.postreader.database.entity.CommentEntity

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 0:45.
 */
@Dao
interface CommentDao {
  @Query(value = "SELECT * FROM comment WHERE postId = :postId")
  fun getComments(postId: Int): List<CommentEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun addComments(comments: List<CommentEntity>): List<Long>
}
