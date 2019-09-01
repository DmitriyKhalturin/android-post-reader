package dmitriykhalturin.postreader.model

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 0:27.
 */
data class Post(
  val userId: Int,
  val id: Int,
  val title: String,
  val body: String
)
