package aaa.admin.checkloadapp.domain.repository

import aaa.admin.checkloadapp.domain.model.Raitings
import retrofit2.Response

interface RateRepository {

    suspend fun getRateList(): Response<Raitings>

}