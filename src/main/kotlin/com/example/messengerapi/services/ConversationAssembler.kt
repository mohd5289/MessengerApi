package com.example.messengerapi.services

import com.example.messengerapi.helpers.`object`.ConversationListVO
import com.example.messengerapi.helpers.`object`.ConversationVO
import com.example.messengerapi.helpers.`object`.MessageVO
import com.example.messengerapi.model.Conversation

class ConversationAssembler(val conversationService:ConversationServiceImpl,
                            val messageAssembler: MessageAssembler){

    fun toConversationVO(conversation: Conversation, userId: Long): ConversationVO {
        val conversationMessages: ArrayList<MessageVO> = ArrayList()
        conversation.messages?.mapTo(conversationMessages) {
            messageAssembler.toMessageVO(it)
        }
        return ConversationVO(conversation.id, conversationService
                .nameSecondParty(conversation, userId),
                conversationMessages)
    }
fun toConversationListVO(conversations: ArrayList<Conversation>,
                         userId: Long): ConversationListVO {
    val conversationVOList = conversations.map { toConversationVO(it,
            userId) }
    return ConversationListVO(conversationVOList)
}





}