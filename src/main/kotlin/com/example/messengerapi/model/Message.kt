package com.example.messengerapi.model

import org.hibernate.annotations.Entity
import org.springframework.data.annotation.Id
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne


    @Entity
    class Message(
            @ManyToOne(optional = false)
            @JoinColumn(name = "user_id", referencedColumnName = "id")
            var sender: User? = null,
            @ManyToOne(optional = false)
            @JoinColumn(name = "recipient_id", referencedColumnName = "id")
            var recipient: User? = null,
            var body: String? = "",
            @ManyToOne(optional = false)
            @JoinColumn(name="conversation_id", referencedColumnName = "id")
            var conversation: Conversation? = null,
            @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0,
            @DateTimeFormat
            var createdAt: Date = Date.from(Instant.now())
    )
