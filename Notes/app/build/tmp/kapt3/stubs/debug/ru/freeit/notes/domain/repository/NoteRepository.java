package ru.freeit.notes.domain.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lru/freeit/notes/domain/repository/NoteRepository;", "", "add", "", "note", "Lru/freeit/notes/domain/entity/Note;", "(Lru/freeit/notes/domain/entity/Note;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "noteBy", "noteId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notesBy", "", "sortingType", "Lru/freeit/notes/domain/repository/SortingType;", "(Lru/freeit/notes/domain/repository/SortingType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "", "update", "app_debug"})
public abstract interface NoteRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object notesBy(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.repository.SortingType sortingType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<ru.freeit.notes.domain.entity.Note>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object add(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.entity.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object noteBy(long noteId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super ru.freeit.notes.domain.entity.Note> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object remove(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.entity.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.entity.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 3)
    public final class DefaultImpls {
    }
}