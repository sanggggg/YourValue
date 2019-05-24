package com.sanggggg.yourvalue

import android.app.Activity
import android.app.Application
import com.sanggggg.yourvalue.di.DaggerAppComponent
import com.sanggggg.yourvalue.di.NetworkModule
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class SquidApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .networkModule(NetworkModule())
            .build()
            .inject(this)

    }
}