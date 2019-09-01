package dmitriykhalturin.postreader

import android.app.Application
import dmitriykhalturin.postreader.di.Injector

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 20:48.
 */
class PostReaderApplication : Application() {

  companion object {
    @JvmStatic
    val injector: Injector by lazy {
      Injector.instance
    }
  }

  override fun onCreate() {
    super.onCreate()

    injector.buildApplicationComponent(this)
  }
}
