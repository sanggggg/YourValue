package com.sanggggg.yourvalue

import android.app.Activity
import android.app.Application
import android.os.Build
import com.sanggggg.yourvalue.di.DaggerAppComponent
import com.sanggggg.yourvalue.di.NetworkModule
import com.sanggggg.yourvalue.di.PreferenceModule
import dagger.android.*
import timber.log.Timber
import javax.inject.Inject

class SquidApplication : DaggerApplication() {

    private val appComponent = DaggerAppComponent.builder()
        .application(this)
        .networkModule(NetworkModule())
        .preferenceModule(PreferenceModule("debug.yourvalue"))
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}