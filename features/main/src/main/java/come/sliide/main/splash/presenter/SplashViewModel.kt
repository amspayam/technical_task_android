package come.sliide.main.splash.presenter

import androidx.lifecycle.MutableLiveData
import com.sliie.components.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel() {

    val navigationToMainFragment = MutableLiveData(false)

    init {
        track {
            delay(2000)
            navigationToMainFragment.postValue(true)
        }
    }
}