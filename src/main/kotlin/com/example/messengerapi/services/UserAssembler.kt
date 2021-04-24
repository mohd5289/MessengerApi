package com.example.messengerapi.services

import com.example.messengerapi.helpers.`object`.UserListVO
import com.example.messengerapi.helpers.`object`.UserVO
import com.example.messengerapi.model.User
import org.springframework.stereotype.Component

@Component
class UserAssembler {
    fun toUserVO(user: User): UserVO {
        return UserVO(user.id, user.username, user.phoneNumber,
                user.status, user.createdAt.toString())
    }
    fun toUserListVO(users: List<User>): UserListVO {
        val userVOList = users.map { toUserVO(it) }
        return UserListVO(userVOList)
    }
}