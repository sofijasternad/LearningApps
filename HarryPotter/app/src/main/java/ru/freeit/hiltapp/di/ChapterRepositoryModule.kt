package ru.freeit.hiltapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.freeit.hiltapp.data.repo.ChapterRepository
import ru.freeit.hiltapp.data.repo.ChapterRepositoryBase

@Module
@InstallIn(ViewModelComponent::class)
abstract class ChapterRepositoryModule {

    @Binds
    abstract fun bindRepository(impl: ChapterRepositoryBase) : ChapterRepository
}