package com.conamobile.dagger2example.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.conamobile.dagger2example.database.dao.UserDao
import com.conamobile.dagger2example.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}