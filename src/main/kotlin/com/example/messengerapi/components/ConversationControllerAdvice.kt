package com.example.messengerapi.components

import com.example.messengerapi.constants.ErrorResponse
import com.example.messengerapi.exceptions.AppExceptions
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler

class ConversationControllerAdvice {
    @ExceptionHandler
    fun conversationIdInvalidException(conversationIdInvalidException:
                                       AppExceptions.ConversationIdInvalidException): ResponseEntity<ErrorResponse> {
        val res = ErrorResponse("", conversationIdInvalidException.message)
        return ResponseEntity.unprocessableEntity().body(res)
    }
}