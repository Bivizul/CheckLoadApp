package aaa.admin.checkloadapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RateApi {

    operator fun invoke() = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://wowowcleaner.com/")
        .build()
        .create(RateService::class.java)

}