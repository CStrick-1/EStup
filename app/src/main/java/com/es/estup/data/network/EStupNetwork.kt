package com.es.estup.data.network

import com.es.estup.data.network.api.DailyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class EStupNetwork {

    // 创建一个接口对象实例
    private val dailyService = ServiceCreator.create(DailyService::class.java)

    suspend fun fetchDailyPic() = dailyService.getDailyPic().await()


    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }
            })
        }
    }

    companion object {
        private var network: EStupNetwork? = null

        fun getInstance(): EStupNetwork {
            if (network == null) {
                synchronized(EStupNetwork::class.java) {
                    if (network == null) {
                        network = EStupNetwork()
                    }
                }
            }
            return network!!
        }
    }


}