package dmitriykhalturin.postreader.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dmitriykhalturin.postreader.database.dao.CommentDao
import dmitriykhalturin.postreader.database.dao.PostDao
import dmitriykhalturin.postreader.database.entity.CommentEntity
import dmitriykhalturin.postreader.database.entity.PostEntity

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 0:40.
 */
@Database(
  entities = [
    PostEntity::class,
    CommentEntity::class
  ],
  version = 1,
  exportSchema = false
)
abstract class SQLiteDatabase : RoomDatabase() {

  companion object {
    private const val DATABASE_NAME = "cache.db"

    @JvmStatic
    private lateinit var instance: SQLiteDatabase

    @JvmStatic
    fun getInstance(context: Context): SQLiteDatabase {
      synchronized(SQLiteDatabase::class.java) {
        if (! Companion::instance.isInitialized) {
          instance = Room
            .databaseBuilder(context, SQLiteDatabase::class.java,
              DATABASE_NAME
            )
            .build()
        }

        return instance
      }
    }
  }

  abstract fun postDao(): PostDao
  abstract fun commentDao(): CommentDao
}
