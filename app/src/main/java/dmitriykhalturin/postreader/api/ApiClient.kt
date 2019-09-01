package dmitriykhalturin.postreader.api

import com.google.gson.GsonBuilder
import com.reader.post.BuildConfig
import dmitriykhalturin.postreader.api.service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 0:24.
 */
class ApiClient @Inject constructor() {

  companion object {
    private const val API_SERVICE_URL = "http://jsonplaceholder.typicode.com"
  }

  private val httpClient: OkHttpClient by lazy {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
      level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
      } else {
        HttpLoggingInterceptor.Level.NONE
      }
    }

    val client = OkHttpClient.Builder()
      .addNetworkInterceptor(loggingInterceptor)
      .build()

    client
  }

  val apiService: ApiService by lazy {
    val gson = GsonBuilder()
      .setLenient()
      .create()

    Retrofit.Builder()
      .client(httpClient)
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .addConverterFactory(GsonConverterFactory.create(gson))
      .baseUrl(API_SERVICE_URL)
      .build()
      .create(ApiService::class.java)
  }
}
