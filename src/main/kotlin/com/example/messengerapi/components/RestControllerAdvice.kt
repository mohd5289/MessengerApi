package com.example.messengerapi.components

import com.example.messengerapi.constants.ErrorResponse
import com.example.messengerapi.exceptions.AppExceptions
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class RestControllerAdvice {
    @ExceptionHandler(AppExceptions.UserDeactivatedException::class)
    fun userDeactivated(userDeactivatedException:
                        AppExceptions.UserDeactivatedException):
            ResponseEntity<ErrorResponse> {
        val res = ErrorResponse(ResponseConstants.ACCOUNT_DEACTIVATED
                .value, userDeactivatedException.message)
// Return an HTTP 403 unauthorized error response
        return ResponseEntity(res, HttpStatus.UNAUTHORIZED)
    }

}