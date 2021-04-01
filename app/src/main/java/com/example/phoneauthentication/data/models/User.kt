package com.example.phoneauthentication.data.models

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_table")
data class User(
    val user_number: String,
    val user_name: String,
    val user_email: String
) : Parcelable
