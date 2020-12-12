package com.es.estup.util

import com.es.estup.data.Repository.DailyRepository
import com.es.estup.data.network.EStupNetwork
import com.es.estup.ui.daily.ModelFactoryDaily

object InjectorUtil {


    private fun getDailyRepository() = DailyRepository.getInstance(EStupNetwork.getInstance())


    fun getModelFactoryDaily() = ModelFactoryDaily(getDailyRepository())



}