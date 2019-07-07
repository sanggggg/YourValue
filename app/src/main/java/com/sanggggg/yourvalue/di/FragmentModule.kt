package com.sanggggg.yourvalue.di

import com.sanggggg.yourvalue.view.intro.WeightFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeWeightFragment() : WeightFragment
}