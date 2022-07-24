package com.conamobile.dagger2example.repository

import com.conamobile.dagger2example.database.dao.UserDao
import com.conamobile.dagger2example.database.entity.UserEntity
import com.conamobile.dagger2example.network.ApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao
) {
    suspend fun getUsers() = flow { emit(apiService.getUsers()) }

    suspend fun insertUsers(list: List<UserEntity>) = userDao.addAll(list)

    suspend fun getDbUsers() = userDao.getUsers()
}