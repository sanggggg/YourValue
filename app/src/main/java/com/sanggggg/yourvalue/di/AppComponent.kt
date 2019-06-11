package com.sanggggg.yourvalue.di

import android.app.Application
import com.sanggggg.yourvalue.SquidApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<SquidApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder
        fun networkModule(networkModule: NetworkModule) : Builder
        fun build() : AppComponent
    }

    override fun inject(instance: SquidApplication)
}