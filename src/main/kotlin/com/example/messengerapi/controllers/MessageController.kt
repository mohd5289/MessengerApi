package com.example.messengerapi.controllers

import com.example.messengerapi.helpers.`object`.MessageVO
import com.example.messengerapi.model.User
import com.example.messengerapi.repositories.UserRepository
import com.example.messengerapi.services.MessageAssembler
import com.example.messengerapi.services.MessageServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/messages")
class MessageController (val messageService: MessageServiceImpl,
                         val userRepository: UserRepository,
                         val messageAssembler: MessageAssembler){
    @PostMapping
    fun create(@RequestBody messageDetails: MessageRequest,
               request: HttpServletRequest): ResponseEntity<MessageVO> {
        val principal = request.userPrincipal
        val sender = userRepository.findByUsername(principal.name) as User
        val message = messageService.sendMessage(sender,
                messageDetails.recipientId, messageDetails.message)
        return ResponseEntity.ok(messageAssembler.toMessageVO(message))
    }
    data class MessageRequest(val recipientId: Long, val message: String)






}