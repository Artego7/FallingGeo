package com.example.fallinggeo.ui

import android.media.Image
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class PageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "$it"
    }
    fun testPVM (string: String){
    val text: LiveData<String> = Transformations.map(_index) {
        Log.d("A",string)
        "Hello world from section: $it"
    }
    }

    fun setIndex(index: Int) {
        _index.value = index
    }
}