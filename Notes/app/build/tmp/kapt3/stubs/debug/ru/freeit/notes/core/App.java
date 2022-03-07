package ru.freeit.notes.core;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lru/freeit/notes/core/App;", "Landroid/app/Application;", "()V", "database", "Lru/freeit/notes/data/db/AppDatabase;", "getDatabase", "()Lru/freeit/notes/data/db/AppDatabase;", "database$delegate", "Lkotlin/Lazy;", "noteRepo", "Lru/freeit/notes/data/repository/NoteRepositoryBase;", "getNoteRepo", "()Lru/freeit/notes/data/repository/NoteRepositoryBase;", "noteRepo$delegate", "tagRepo", "Lru/freeit/notes/data/repository/TagRepositoryBase;", "getTagRepo", "()Lru/freeit/notes/data/repository/TagRepositoryBase;", "tagRepo$delegate", "viewModelFactories", "Lru/freeit/notes/core/ViewModelFactories;", "getViewModelFactories", "()Lru/freeit/notes/core/ViewModelFactories;", "viewModelFactories$delegate", "app_debug"})
public final class App extends android.app.Application {
    private final kotlin.Lazy database$delegate = null;
    private final kotlin.Lazy noteRepo$delegate = null;
    private final kotlin.Lazy tagRepo$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModelFactories$delegate = null;
    
    public App() {
        super();
    }
    
    private final ru.freeit.notes.data.db.AppDatabase getDatabase() {
        return null;
    }
    
    private final ru.freeit.notes.data.repository.NoteRepositoryBase getNoteRepo() {
        return null;
    }
    
    private final ru.freeit.notes.data.repository.TagRepositoryBase getTagRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.freeit.notes.core.ViewModelFactories getViewModelFactories() {
        return null;
    }
}