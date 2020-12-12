package com.es.estup.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object ServiceCreator {

    private const val BASE_URL = "https://open.iciba.com/"

    //简单来说，通过OkHttpClient可以发送一个Http请求，并读取该Http请求的响应，它是一个生产Call的工厂
    private val httpClient = OkHttpClient.Builder()

    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient.build())
        // ScalarsConverterFactory: String等类型转换，如果没有的话返回null
        .addConverterFactory(ScalarsConverterFactory.create())
        //GsonConverterFactory： Gson转换器
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = builder.build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)



}