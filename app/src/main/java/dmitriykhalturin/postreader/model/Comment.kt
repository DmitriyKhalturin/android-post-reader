package dmitriykhalturin.postreader.model

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 0:29.
 */
data class Comment(
  val postId: Int,
  val id: Int,
  val name: String,
  val email: String,
  val body: String
)
