package com.conamobile.dagger2example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.conamobile.dagger2example.database.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    suspend fun addUser(userEntity: UserEntity)

    @Query("select * from userentity")
    suspend fun getUsers(): List<UserEntity>

    @Insert(onConflict = REPLACE)
    suspend fun addAll(list: List<UserEntity>)
}