package com.es.estup.ui.daily

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.es.estup.data.Repository.DailyRepository

class ModelFactoryDaily(private val repository: DailyRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelDaily(repository) as T
    }

}