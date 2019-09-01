package dmitriykhalturin.postreader.repository

import dmitriykhalturin.postreader.model.Post
import dmitriykhalturin.postreader.model.PostWithComments
import io.reactivex.Single

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 31.08.19 23:50.
 */
interface PostRepository {
  fun getPosts(): Single<List<Post>>
  fun getPost(postId: Int): Single<PostWithComments>
}
