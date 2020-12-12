package com.es.estup.data.model

import com.google.gson.annotations.SerializedName

/*
    词霸：每日一句
    api: https://open.iciba.com/dsapi/
 */
data class Daily(
    // picture  ： 包括日期，中英文
    @SerializedName("fenxiang_img")
    val fenxiangImg: String,
    //
    @SerializedName("tags")
    val tags: List<Any>,
    // 发音
    @SerializedName("tts")
    val tts: String
)