package com.example.messengerapi.repositories

import com.example.messengerapi.model.Conversation
import org.springframework.data.repository.CrudRepository

interface ConversationRepository:CrudRepository<Conversation,Long> {
    fun findBySenderId(id: Long): List<Conversation>
    fun findByRecipientId(id: Long): List<Conversation>
    fun findBySenderIdAndRecipientId(senderId: Long,
                                     recipientId: Long): Conversation?
}