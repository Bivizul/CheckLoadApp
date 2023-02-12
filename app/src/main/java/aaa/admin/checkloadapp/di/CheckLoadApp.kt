package aaa.admin.checkloadapp.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CheckLoadApp : Application() {

//    lateinit var appComponent: AppComponent
//        private set
//
//    override fun onCreate() {
//        super.onCreate()
//        appComponent = DaggerAppComponent.create()
//    }
}

//val Context.appComponent: AppComponent
//    get() = when (this) {
//        is CheckLoadApp -> appComponent
//        else -> applicationContext.appComponent
//    }