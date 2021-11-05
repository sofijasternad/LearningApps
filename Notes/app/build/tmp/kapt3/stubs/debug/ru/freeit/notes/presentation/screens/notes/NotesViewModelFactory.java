package ru.freeit.notes.presentation.screens.notes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ7\u0010\u000b\u001a\u0002H\f\"\n\b\u0000\u0010\f*\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\f0\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014\u00a2\u0006\u0002\u0010\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lru/freeit/notes/presentation/screens/notes/NotesViewModelFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "bundle", "Landroid/os/Bundle;", "noteRepo", "Lru/freeit/notes/domain/repository/NoteRepository;", "tagRepo", "Lru/freeit/notes/domain/repository/TagRepository;", "(Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;Lru/freeit/notes/domain/repository/NoteRepository;Lru/freeit/notes/domain/repository/TagRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "app_debug"})
public final class NotesViewModelFactory extends androidx.lifecycle.AbstractSavedStateViewModelFactory {
    private final androidx.savedstate.SavedStateRegistryOwner owner = null;
    private final android.os.Bundle bundle = null;
    private final ru.freeit.notes.domain.repository.NoteRepository noteRepo = null;
    private final ru.freeit.notes.domain.repository.TagRepository tagRepo = null;
    
    public NotesViewModelFactory(@org.jetbrains.annotations.NotNull()
    androidx.savedstate.SavedStateRegistryOwner owner, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle, @org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.repository.NoteRepository noteRepo, @org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.repository.TagRepository tagRepo) {
        super(null, null);
    }
    
    @java.lang.Override()
    protected <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle handle) {
        return null;
    }
}