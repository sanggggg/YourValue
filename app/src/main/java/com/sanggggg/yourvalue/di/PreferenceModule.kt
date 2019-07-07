package com.sanggggg.yourvalue.di

import android.content.Context
import android.content.SharedPreferences
import com.sanggggg.yourvalue.model.Squid
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class PreferenceModule(private val prefKey : String) {
    @Provides
    @Singleton
    fun provideMoshi() : Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun provideAdapter(moshi : Moshi) : JsonAdapter<Squid> {
        return moshi.adapter(Squid::class.java)
    }

    @Provides
    @Singleton
    fun provideSharedPreference(context : Context) : SharedPreferences {
        return context.getSharedPreferences(prefKey, Context.MODE_PRIVATE)
    }

}