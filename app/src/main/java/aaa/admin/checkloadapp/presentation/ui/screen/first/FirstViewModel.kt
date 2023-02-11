package aaa.admin.checkloadapp.presentation.ui.screen.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FirstViewModel : ViewModel() {

    var downloadedPercentage = MutableLiveData<Float>()

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
                            downloadedPercentage.value =
                                ((downloadedSize / totalDownloadSize) * 100)
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            downloadedPercentage.value = 100f
                        }
                        break
                    }
                    delay(1000)
                }
            }
        }
    }

}