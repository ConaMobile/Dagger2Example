package com.conamobile.dagger2example

import android.app.Application
import com.conamobile.dagger2example.di.component.AppComponent
import com.conamobile.dagger2example.di.component.DaggerAppComponent
import com.conamobile.dagger2example.di.module.DatabaseModule

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .databaseModule(DatabaseModule(this))
            .build()
    }
}