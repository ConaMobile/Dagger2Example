package com.conamobile.dagger2example.di.component

import com.conamobile.dagger2example.MainActivity
import com.conamobile.dagger2example.di.module.DatabaseModule
import com.conamobile.dagger2example.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}