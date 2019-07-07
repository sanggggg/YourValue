package com.sanggggg.yourvalue.di

import com.sanggggg.yourvalue.view.intro.IntroActivity
import com.sanggggg.yourvalue.view.main.MainActivity
import com.sanggggg.yourvalue.view.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeIntroActivity(): IntroActivity
}