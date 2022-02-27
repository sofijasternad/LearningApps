package ru.freeit.hiltapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.freeit.hiltapp.data.local.ChapterLocalDataSource
import ru.freeit.hiltapp.data.local.ChapterLocalDataSourceBase

@Module
@InstallIn(SingletonComponent::class)
abstract class ChapterLocalDataSourceModule {

    @Binds
    abstract fun bindLocalSource(chapterLocalDataSource: ChapterLocalDataSourceBase) : ChapterLocalDataSource

}