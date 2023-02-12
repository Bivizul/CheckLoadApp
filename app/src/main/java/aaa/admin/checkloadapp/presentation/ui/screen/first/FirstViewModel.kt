package aaa.admin.checkloadapp.presentation.ui.screen.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor() : ViewModel() {

    private val _downloadedPercentage = MutableLiveData<Float>()
    val downloadedPercentage: LiveData<Float> = _downloadedPercentage

    fun startThreadGradient() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                val totalDownloadSize = 14f // 14 sec
                var downloadedSize = 0f
                while (true) {
//                    downloadedSize += ((1..100).random().toFloat())
                    downloadedSize += 1
                    if (downloadedSize < totalDownloadSize) {
                        withContext(Dispatchers.Main) {
                            _downloadedPercentage.value =
                                ((downloadedSize / totalDownloadSize) * 100)
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            _downloadedPercentage.value = 100f
                        }
                        break
                    }
                    delay(1000)
                }
            }
        }
    }

}