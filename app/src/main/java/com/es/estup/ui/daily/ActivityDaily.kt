package com.es.estup.ui.daily


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider


import com.es.estup.R
import com.es.estup.databinding.ActSplashBinding

import com.es.estup.util.InjectorUtil
import com.google.android.exoplayer2.util.Log
import kotlinx.android.synthetic.main.act_splash.*

class ActivityDaily : AppCompatActivity() {


    val viewModel by lazy { ViewModelProvider(this
        , InjectorUtil.getModelFactoryDaily()).get(ViewModelDaily::class.java) }

    //实例化（绑定）布局文件 ，绑定之后将数据传递给布局文件
    private val binding by lazy { DataBindingUtil
        .setContentView<ActSplashBinding>(this
            , R.layout.act_splash) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //将数据传递到布局文件
        binding.splash = viewModel

        binding.lifecycleOwner = this

        viewModel.getPicutre()
    }



}