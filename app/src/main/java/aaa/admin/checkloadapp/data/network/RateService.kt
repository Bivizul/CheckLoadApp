package aaa.admin.checkloadapp.data.network

import aaa.admin.checkloadapp.domain.model.Raitings
import retrofit2.Response
import retrofit2.http.GET

interface RateService {

    @GET("testAndroidData")
    suspend fun getRateList(): Response<Raitings>

}