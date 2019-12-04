package com.sendy.chatapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatViewModel : ViewModel(){

        val _text = MutableLiveData<String>().apply {
            value = "Welcome to chat Fragment"
        }
        val text: LiveData<String> = _text

    private val _sendText = MutableLiveData<String>().apply {
        value = "This is send Fragment"
    }
    val sendText: LiveData<String> = _sendText

    private val _shareText = MutableLiveData<String>().apply {
        value = "This is share Fragment"
    }
    val shareText: LiveData<String> = _shareText

}