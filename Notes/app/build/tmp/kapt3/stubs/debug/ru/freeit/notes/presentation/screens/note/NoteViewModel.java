package ru.freeit.notes.presentation.screens.note;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001c\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lru/freeit/notes/presentation/screens/note/NoteViewModel;", "Lru/freeit/notes/core/CoroutineViewModel;", "noteId", "", "repo", "Lru/freeit/notes/domain/repository/NoteRepository;", "(JLru/freeit/notes/domain/repository/NoteRepository;)V", "status", "Lru/freeit/notes/core/LiveDataWrapper;", "Lru/freeit/notes/presentation/screens/note/NoteStatus;", "add", "", "title", "", "apply", "edit", "fetchNoteById", "observeStatus", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "app_debug"})
public final class NoteViewModel extends ru.freeit.notes.core.CoroutineViewModel {
    private final long noteId = 0L;
    private final ru.freeit.notes.domain.repository.NoteRepository repo = null;
    private final ru.freeit.notes.core.LiveDataWrapper<ru.freeit.notes.presentation.screens.note.NoteStatus> status = null;
    
    public NoteViewModel(long noteId, @org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.repository.NoteRepository repo) {
        super();
    }
    
    private final void fetchNoteById(long noteId) {
    }
    
    public final void observeStatus(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Observer<ru.freeit.notes.presentation.screens.note.NoteStatus> observer) {
    }
    
    private final void edit(java.lang.String title) {
    }
    
    private final void add(java.lang.String title) {
    }
    
    public final void apply(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
}