package aaa.admin.checkloadapp.data.repository

import aaa.admin.checkloadapp.data.network.RateService
import aaa.admin.checkloadapp.domain.model.Raitings
import aaa.admin.checkloadapp.domain.repository.RateRepository
import retrofit2.Response
import javax.inject.Inject

class RateRepositoryImpl @Inject constructor(private val rateService: RateService) :
    RateRepository {

    override suspend fun getRateList(): Response<Raitings> = rateService.getRateList()
}