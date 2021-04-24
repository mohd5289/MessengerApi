package com.example.messengerapi.repositories

import com.example.messengerapi.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository:CrudRepository<User,Long>{
    fun findByUsername(username: String): User?
    fun findByPhoneNumber(phoneNumber: String): User?
}