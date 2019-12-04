package com.sendy.chatapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sendy.chatapp.R
import com.sendy.chatapp.viewmodel.ChatViewModel

class ChatFragment : Fragment() {
    lateinit var chatViewModel: ChatViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        chatViewModel = ViewModelProviders.of(this).get(ChatViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_chat, container, false)
        val tvChat: TextView = root.findViewById(R.id.tvChatFragment)
        chatViewModel.text.observe(this, Observer {
            tvChat.text = it
        })
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {




    }
}