package com.example.phoneauthentication.data.models

import androidx.room.Entity


@Entity()
data class User(
    val user_number: String,
    val user_name: String,
    val user_email: String
)
