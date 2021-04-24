package com.example.messengerapi.components

import com.example.messengerapi.constants.ErrorResponse
import com.example.messengerapi.exceptions.AppExceptions
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class MessageControllerAdvice {
    @ExceptionHandler(AppExceptions.MessageEmptyException::class)
    fun messageEmpty(messageEmptyException: AppExceptions.MessageEmptyException):
            ResponseEntity<ErrorResponse> {
//ErrorResponse object creation
        val res = ErrorResponse(ResponseConstants.MESSAGE_EMPTY.value,
                messageEmptyException.message)
// Returning ResponseEntity containing appropriate ErrorResponse
        return ResponseEntity.unprocessableEntity().body(res)
    }
    @ExceptionHandler(AppExceptions.MessageRecipientInvalidException::class)
    fun messageRecipientInvalid(messageRecipientInvalidException:
                                AppExceptions.MessageRecipientInvalidException):
            ResponseEntity<ErrorResponse> {
        val res = ErrorResponse(ResponseConstants.MESSAGE_RECIPIENT_INVALID
                .value, messageRecipientInvalidException.message)
        return ResponseEntity.unprocessableEntity().body(res)

    }
    }