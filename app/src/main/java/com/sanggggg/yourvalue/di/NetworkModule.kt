package com.sanggggg.yourvalue.di

import com.sanggggg.yourvalue.R
import com.sanggggg.yourvalue.network.SquidService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(R.string.api_URL.toString())
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSquidService(retrofit : Retrofit): SquidService {
        return retrofit.create(SquidService::class.java)
    }

}