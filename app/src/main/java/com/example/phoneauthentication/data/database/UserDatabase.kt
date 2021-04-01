package com.example.phoneauthentication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.phoneauthentication.data.models.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
}