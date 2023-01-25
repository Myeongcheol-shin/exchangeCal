package com.shino72.exchangecal.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    private val _text : MutableLiveData<String> = MutableLiveData()
    val text : LiveData<String> get() = _text
    init {
        _text.value = ""
    }
    fun zero(){
        if(_text.value != "") _text.value += "0"
    }
    fun one(){_text.value += "1"}
    fun two(){_text.value += "2"}
    fun three(){_text.value += "3"}
    fun four(){_text.value += "4"}
    fun five(){_text.value += "5"}
    fun six(){_text.value += "6"}
    fun seven(){_text.value += "7"}
    fun eight(){_text.value += "8"}
    fun nine(){_text.value += "9"}
    fun clear(){_text.value = ""}
    fun back(){_text.value = _text.value!!.dropLast(1)}
}