package com.es.estup.data.network.api

import com.es.estup.data.model.Daily
import retrofit2.Call
import retrofit2.http.GET

interface DailyService {

    // https://open.iciba.com/dsapi/

    @GET("dsapi")
    fun getDailyPic(): Call<Daily>
}