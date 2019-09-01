package dmitriykhalturin.postreader.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dmitriykhalturin.postreader.database.entity.PostEntity
import dmitriykhalturin.postreader.database.entity.PostWithCommentsEntity

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 0:45.
 */
@Dao
interface PostDao {
  @Query(value = "SELECT * FROM post")
  fun getPosts(): List<PostEntity>

  @Query(value = "SELECT * FROM post WHERE id = :postId")
  fun getPost(postId: Int): PostEntity?

  @Query(value = "SELECT * FROM post WHERE id = :postId")
  fun getPostWithComments(postId: Int): PostWithCommentsEntity?

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  fun addPost(post: PostEntity): Long

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  fun addPosts(posts: List<PostEntity>): List<Long>
}
