package com.example.messengerapi.services

import com.example.messengerapi.helpers.`object`.MessageVO
import com.example.messengerapi.model.Message

class MessageAssembler {
    fun toMessageVO(message: Message): MessageVO {
        return MessageVO(message.id, message.sender?.id,
                message.recipient?.id, message.conversation?.id,
                message.body, message.createdAt.toString())
    }
}