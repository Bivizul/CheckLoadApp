package aaa.admin.checkloadapp.data.repository

import aaa.admin.checkloadapp.data.network.RateService
import aaa.admin.checkloadapp.domain.repository.RateRepository

class RateRepositoryImpl(val rateService: RateService) : RateRepository {

    override suspend fun getRateList() = rateService.getRateList()
}