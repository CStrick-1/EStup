package com.es.estup.ui.daily

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.es.estup.EStupApplication
import com.es.estup.data.Repository.DailyRepository
import com.es.estup.data.model.Daily
import kotlinx.coroutines.launch

class ViewModelDaily(private val repository: DailyRepository): ViewModel() {

    var picture = MutableLiveData<Daily>()

    fun getPicutre() {
        launch {
            picture.value = repository.getDailyPic()
        }
    }


    private fun launch(block: suspend () -> Unit) = viewModelScope.launch {
        try {
            block()
        } catch (e: Throwable) {
            error(e)
        }
    }


}