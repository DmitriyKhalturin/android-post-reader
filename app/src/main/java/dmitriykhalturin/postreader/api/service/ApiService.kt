package dmitriykhalturin.postreader.api.service

import dmitriykhalturin.postreader.model.Comment
import dmitriykhalturin.postreader.model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 0:25.
 */
interface ApiService {
  @GET(value = "/posts")
  fun getPosts(): Observable<List<Post>>

  @GET(value = "/posts/{postId}")
  fun getPost(
    @Path(value = "postId") postId: Int
  ): Observable<Post>

  @GET(value = "/comments")
  fun getCommentsByPost(
    @Query(value = "postId") postId: Int
  ): Observable<List<Comment>>

  @GET(value = "/posts")
  fun getPostsByUser(
    @Query(value = "userId") userId: Int
  ): Observable<List<Post>>
}
