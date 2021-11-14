package ru.freeit.hiltapp.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ActivityComponent::class)
class ChapterCoroutineDispatcherModule {
    @Provides
    fun provideDispatcher() : CoroutineDispatcher = Dispatchers.IO
}