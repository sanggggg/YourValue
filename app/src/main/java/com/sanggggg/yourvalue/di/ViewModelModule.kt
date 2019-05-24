package com.sanggggg.yourvalue.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sanggggg.yourvalue.view.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: viewModelFactory): ViewModelProvider.Factory
}