package com.example.messengerapi.services

import com.example.messengerapi.model.Message
import com.example.messengerapi.model.User

interface MessageService {

    fun sendMessage(sender: User, recipientId: Long,
                    messageText: String): Message

}