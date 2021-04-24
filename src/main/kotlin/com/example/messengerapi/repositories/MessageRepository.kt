package com.example.messengerapi.repositories

import com.example.messengerapi.model.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepository:CrudRepository<Message,Long> {
    fun findByConversationId(conversationId: Long): List<Message>

}