package aaa.admin.checkloadapp.presentation.ui.screen.second

import android.content.ContentValues.TAG
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class SecondViewModel() : ViewModel() {

    private val _reverseCounter = MutableLiveData<Long>()
    val reverseCounter : LiveData<Long> = _reverseCounter




    private val _randomDownloadedPercentage1 = MutableLiveData<Float>()
    val randomDownloadedPercentage1 : LiveData<Float> = _randomDownloadedPercentage1

    private val _randomDownloadedPercentage2 = MutableLiveData<Float>()
    val randomDownloadedPercentage2 : LiveData<Float> = _randomDownloadedPercentage2

    val job1 = SupervisorJob()

//    fun getListRate() {
//        viewModelScope.launch {
//            val a = rateRepository.getRateList()
//
//        }
//    }

    fun clearAndRestartProgressBars(){
        viewModelScope.coroutineContext.cancelChildren()
        _randomDownloadedPercentage1.value = 0f
        _randomDownloadedPercentage2.value = 0f
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                delay(1000)
            }
            startThreadGradient1()
            startThreadGradient2()
        }
    }

    fun startThreadGradient1() {
        Log.e(TAG, "startThreadGradient1: ", )
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                val totalDownloadSize = (5..25).random()
                var downloadedSize = 0f
                while (true) {
//                    downloadedSize += ((1..100).random().toFloat())
                    downloadedSize += 1
                    if (downloadedSize < totalDownloadSize) {
                        withContext(Dispatchers.Main) {
                            _randomDownloadedPercentage1.value =
                                ((downloadedSize / totalDownloadSize) * 100)
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            _randomDownloadedPercentage1.value = 100f
                        }
                        break
                    }
                    delay(1000)
                }
            }
        }
    }

    fun startThreadGradient2() {
        Log.e(TAG, "startThreadGradient2: ", )
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                val totalDownloadSize = (5..25).random()
                var downloadedSize = 0f
                while (true) {
//                    downloadedSize += ((1..100).random().toFloat())
                    downloadedSize += 1
                    if (downloadedSize < totalDownloadSize) {
                        withContext(Dispatchers.Main) {
                            _randomDownloadedPercentage2.value =
                                ((downloadedSize / totalDownloadSize) * 100)
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            _randomDownloadedPercentage2.value = 100f
                        }
                        break
                    }
                    delay(1000)
                }
            }
        }
    }

    fun startReverseCounter(timer:Long){
        viewModelScope.launch {
            val countDown :CountDownTimer
            withContext(Dispatchers.Main){
                countDown = object : CountDownTimer(timer,1000L){
                    override fun onTick(millisUntilFinished: Long) {
                        _reverseCounter.value = millisUntilFinished
                    }

                    override fun onFinish() {
                        this.cancel()
                    }
                }
                delay(1000L)
                countDown.start()
            }
        }
    }

}