package aaa.admin.checkloadapp.presentation.ui.screen.second

import aaa.admin.checkloadapp.domain.repository.RateRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SecondViewModel(val rateRepository: RateRepository) : ViewModel() {


    fun getListRate() {
        viewModelScope.launch {
            val a = rateRepository.getRateList()

        }
    }

}