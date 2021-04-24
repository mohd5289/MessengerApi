package com.example.messengerapi.components

import com.example.messengerapi.constants.ErrorResponse
import com.example.messengerapi.exceptions.AppExceptions
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class UserControllerAdvice {
    @ExceptionHandler(AppExceptions.UsernameUnavailableException::class)
    fun usernameUnavailable(usernameUnavailableException:
                            AppExceptions.UsernameUnavailableException):
            ResponseEntity<ErrorResponse> {
        val res = ErrorResponse(ResponseConstants.USERNAME_UNAVAILABLE
                .value, usernameUnavailableException.message)
        return ResponseEntity.unprocessableEntity().body(res)
    }
    @ExceptionHandler(AppExceptions.InvalidUserIdException::class)
    fun invalidId(invalidUserIdException: AppExceptions.InvalidUserIdException):
            ResponseEntity<ErrorResponse> {
        val res = ErrorResponse(ResponseConstants.INVALID_USER_ID.value,
                invalidUserIdException.message)
        return ResponseEntity.badRequest().body(res)
    }
    @ExceptionHandler(AppExceptions.UserStatusEmptyException::class)
    fun statusEmpty(userStatusEmptyException: AppExceptions.UserStatusEmptyException):
            ResponseEntity<ErrorResponse> {
        val res = ErrorResponse(ResponseConstants.EMPTY_STATUS.value,
                userStatusEmptyException.message)
        return ResponseEntity.unprocessableEntity().body(res)
    }
}