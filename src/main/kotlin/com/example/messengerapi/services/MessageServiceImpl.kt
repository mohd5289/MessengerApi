package com.example.messengerapi.services

import com.example.messengerapi.exceptions.AppExceptions
import com.example.messengerapi.model.Conversation
import com.example.messengerapi.model.Message
import com.example.messengerapi.model.User
import com.example.messengerapi.repositories.ConversationRepository
import com.example.messengerapi.repositories.MessageRepository
import com.example.messengerapi.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(val repository: MessageRepository,
                         val conversationRepository: ConversationRepository,
                         val conversationService: ConversationService,
                         val userRepository: UserRepository) :MessageService{


    @Throws(AppExceptions.MessageEmptyException::class,
            AppExceptions.MessageRecipientInvalidException::class)
    override fun sendMessage(sender: User, recipientId: Long,
                             messageText: String): Message {
        val optional = userRepository.findById(recipientId)
        if (optional.isPresent) {
            val recipient = optional.get()
            if (!messageText.isEmpty()) {
                val conversation: Conversation = if (conversationService
                                .conversationExists(sender, recipient)) {
                    conversationService.getConversation(sender, recipient)
                            as Conversation
                } else {
                    conversationService.createConversation(sender, recipient)
                }
                conversationRepository.save(conversation)
                val message = Message(sender, recipient, messageText,
                        conversation)
                repository.save(message)
                return message
            }
        } else {
            throw AppExceptions.MessageRecipientInvalidException("The recipient id'$recipientId' is invalid.")
        }
        throw AppExceptions.MessageEmptyException()
    }

}