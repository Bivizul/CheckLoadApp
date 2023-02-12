//package aaa.admin.checkloadapp.presentation.ui.screen.second
//
//import aaa.admin.checkloadapp.domain.repository.RateRepository
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import dagger.assisted.AssistedFactory
//import dagger.assisted.AssistedInject
//
//class SecondViewModelFactory @AssistedInject constructor(
//    private val rateRepository: RateRepository,
//) : ViewModelProvider.Factory {
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return SecondViewModel(rateRepository) as T
//    }
//
//    @AssistedFactory
//    interface Factory {
//        fun create(): SecondViewModelFactory
//    }
//
//}