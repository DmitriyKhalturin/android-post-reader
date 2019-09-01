package dmitriykhalturin.postreader.di

import android.app.Application
import dmitriykhalturin.postreader.di.component.ApplicationComponent
import dmitriykhalturin.postreader.di.component.DaggerApplicationComponent
import dmitriykhalturin.postreader.di.module.ApplicationModule

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 20:49.
 */
class Injector {
  companion object {
    @JvmStatic
    val instance: Injector by lazy {
      Injector()
    }

    @JvmStatic
    private lateinit var instanceApplicationComponent: ApplicationComponent
  }

  fun buildApplicationComponent(application: Application) {
    instanceApplicationComponent = DaggerApplicationComponent.builder()
      .applicationModule(ApplicationModule(application))
      .build()
  }

  val applicationComponent: ApplicationComponent
    get() = instanceApplicationComponent
}
