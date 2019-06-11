package com.sanggggg.yourvalue

import android.app.Activity
import android.app.Application
import android.os.Build
import com.sanggggg.yourvalue.di.DaggerAppComponent
import com.sanggggg.yourvalue.di.NetworkModule
import dagger.android.*
import javax.inject.Inject

class SquidApplication : DaggerApplication(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = activityInjector

    private val appComponent = DaggerAppComponent.builder()
        .application(this)
        .networkModule(NetworkModule())
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)

    }
}