package com.conamobile.dagger2example.utils

import com.conamobile.dagger2example.database.entity.UserEntity

sealed class UserResource {

    object Loading : UserResource()

    data class Success(val list: List<UserEntity>) : UserResource()

    data class Error(val message: String) : UserResource()
}