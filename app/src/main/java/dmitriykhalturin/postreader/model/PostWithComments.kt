package dmitriykhalturin.postreader.model

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 01.09.19 0:03.
 */
data class PostWithComments(
  val post: Post,
  val comments: List<Comment>
)
