package com.es.estup.data.Repository

import com.es.estup.data.model.Daily
import com.es.estup.data.network.EStupNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DailyRepository(private val network: EStupNetwork) {



    suspend fun getDailyPic(): Daily {
        var url = requestDailyPic()
        return url
    }
    suspend fun refreshDailyPic() = requestDailyPic()

    private suspend fun requestDailyPic() = withContext(Dispatchers.IO) {
        val url = network.fetchDailyPic()
        url
    }

    companion object {

        private lateinit var instance: DailyRepository

        fun getInstance(network: EStupNetwork): DailyRepository {
            if (!::instance.isInitialized) {
                synchronized(DailyRepository::class.java) {
                    if (!::instance.isInitialized) {
                        instance = DailyRepository(network)
                    }
                }
            }
            return instance
        }
    }



}