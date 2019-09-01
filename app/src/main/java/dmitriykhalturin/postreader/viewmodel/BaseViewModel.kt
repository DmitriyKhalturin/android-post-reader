package dmitriykhalturin.postreader.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for Post Reader on 01.09.19 1:00.
 */
open class BaseViewModel : ViewModel() {

  private val compositeDisposable = CompositeDisposable()

  var disposable: Disposable?
    get() = null
    set(value) {
      value?.let {
        compositeDisposable.add(it)
      }
    }

  override fun onCleared() {
    compositeDisposable.dispose()

    super.onCleared()
  }
}
