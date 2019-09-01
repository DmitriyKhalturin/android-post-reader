package dmitriykhalturin.postreader.di.component

import dmitriykhalturin.postreader.di.module.ApplicationModule
import dmitriykhalturin.postreader.viewmodel.PostDetailViewModel
import dmitriykhalturin.postreader.viewmodel.PostListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 30.08.19 20:51.
 */
@Singleton
@Component(
  modules = [
    ApplicationModule::class
  ]
)
interface ApplicationComponent {
  fun inject(viewModel: PostListViewModel)
  fun inject(viewModel: PostDetailViewModel)
}
