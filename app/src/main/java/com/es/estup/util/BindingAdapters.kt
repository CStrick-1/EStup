package com.es.estup.util

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil

import com.bumptech.glide.Glide
import com.es.estup.R
import com.es.estup.data.model.Daily


/*
    DataBinding 适配器
 */
//
// //获取splashPic
//@BindingAdapter("bind:loadSplashPicture")
//fun LinearLayout.loadSplashPicture(daily: Daily?) = daily?.let  {
//    removeAllViews()
//    for (splash in it.fenxiangImg) {
//        val view = LayoutInflater.from(context).inflate(R.layout.item_splash_picture
//            , this, false)
//        DataBindingUtil
//                .bind<com.es.estup.databinding.ItemSplashPictureBinding>(view)
//                ?.splashpicture = splash.toString()
//        addView(view)
//    }
//}

// splash picture ：每日一句
@BindingAdapter("bind:loadSplashPicture")
fun ImageView.loadSplashPicture(url: String?) {
    if (url != null)
    Glide.with(context).load(url).into(this)
}



