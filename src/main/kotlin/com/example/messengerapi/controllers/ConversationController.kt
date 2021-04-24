package com.example.messengerapi.controllers

import com.example.messengerapi.helpers.`object`.ConversationListVO
import com.example.messengerapi.helpers.`object`.ConversationVO
import com.example.messengerapi.model.User
import com.example.messengerapi.repositories.UserRepository
import com.example.messengerapi.services.ConversationAssembler
import com.example.messengerapi.services.ConversationServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/conversations")
class ConversationController(
        val conversationService: ConversationServiceImpl,
        val conversationAssembler: ConversationAssembler,
        val userRepository: UserRepository) {
    @GetMapping
    fun list(request: HttpServletRequest): ResponseEntity<ConversationListVO> {
        val user = userRepository.findByUsername(request
                .userPrincipal.name) as User
        val conversations = conversationService.listUserConversations(user.id)
        return ResponseEntity.ok(conversationAssembler
                .toConversationListVO(conversations, user.id))
    }
    @GetMapping
    @RequestMapping("/{conversation_id}")
    fun show(@PathVariable(name = "conversation_id") conversationId: Long,
             request: HttpServletRequest): ResponseEntity<ConversationVO> {
        val user = userRepository.findByUsername(request
                .userPrincipal.name) as User
        val conversationThread = conversationService.retrieveThread(conversationId)
        return ResponseEntity.ok(conversationAssembler
                .toConversationVO(conversationThread, user.id))
    }








}