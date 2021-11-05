package ru.freeit.notes.presentation.screens.note;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J1\u0010\u0015\u001a\u00020\u00102\'\u0010\u0016\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00100\u0017H\u0002J\u0006\u0010\u001b\u001a\u00020\u0010J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001c\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\"J\"\u0010#\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\"J\u000e\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lru/freeit/notes/presentation/screens/note/NoteViewModel;", "Lru/freeit/notes/core/CoroutineViewModel;", "noteId", "", "noteRepo", "Lru/freeit/notes/domain/repository/NoteRepository;", "tagRepo", "Lru/freeit/notes/domain/repository/TagRepository;", "(JLru/freeit/notes/domain/repository/NoteRepository;Lru/freeit/notes/domain/repository/TagRepository;)V", "status", "Lru/freeit/notes/core/LiveDataWrapper;", "Lru/freeit/notes/presentation/screens/note/NoteStatus;", "tags", "", "Lru/freeit/notes/domain/entity/Tag;", "add", "", "title", "", "addTag", "apply", "changeTags", "onChange", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "clearTags", "edit", "fetchNoteById", "observeStatus", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "observeTags", "removeTag", "tag", "app_debug"})
public final class NoteViewModel extends ru.freeit.notes.core.CoroutineViewModel {
    private final long noteId = 0L;
    private final ru.freeit.notes.domain.repository.NoteRepository noteRepo = null;
    private final ru.freeit.notes.domain.repository.TagRepository tagRepo = null;
    private final ru.freeit.notes.core.LiveDataWrapper<ru.freeit.notes.presentation.screens.note.NoteStatus> status = null;
    private final ru.freeit.notes.core.LiveDataWrapper<java.util.List<ru.freeit.notes.domain.entity.Tag>> tags = null;
    
    public NoteViewModel(long noteId, @org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.repository.NoteRepository noteRepo, @org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.repository.TagRepository tagRepo) {
        super();
    }
    
    private final void fetchNoteById(long noteId) {
    }
    
    public final void clearTags() {
    }
    
    public final void observeTags(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Observer<java.util.List<ru.freeit.notes.domain.entity.Tag>> observer) {
    }
    
    public final void observeStatus(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Observer<ru.freeit.notes.presentation.screens.note.NoteStatus> observer) {
    }
    
    public final void addTag(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    public final void removeTag(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.entity.Tag tag) {
    }
    
    private final void changeTags(kotlin.jvm.functions.Function1<? super java.util.List<ru.freeit.notes.domain.entity.Tag>, kotlin.Unit> onChange) {
    }
    
    private final void edit(java.lang.String title) {
    }
    
    private final void add(java.lang.String title) {
    }
    
    public final void apply(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
}