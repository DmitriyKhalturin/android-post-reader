package dmitriykhalturin.postreader.di.module

import android.app.Application
import android.content.Context
import dmitriykhalturin.postreader.api.ApiClient
import dmitriykhalturin.postreader.database.DBClient
import dmitriykhalturin.postreader.repository.PostRepository
import dmitriykhalturin.postreader.repository.PostRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 20:51.
 */
@Module
class ApplicationModule(private val application: Application) {
  @Singleton
  @Provides
  fun provideContext(): Context = application

  @Singleton
  @Provides
  fun provideApiClient() = ApiClient()

  @Singleton
  @Provides
  fun provideDBClient() = DBClient(application)

  @Singleton
  @Provides
  fun providePostRepository(repository: PostRepositoryImpl): PostRepository = repository
}
