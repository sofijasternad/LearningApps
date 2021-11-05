package ru.freeit.notes.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lru/freeit/notes/data/repository/NoteRepositoryImpl;", "Lru/freeit/notes/domain/repository/NoteRepository;", "appDatabase", "Lru/freeit/notes/data/db/AppDatabase;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lru/freeit/notes/data/db/AppDatabase;Lkotlinx/coroutines/CoroutineDispatcher;)V", "noteDao", "Lru/freeit/notes/data/db/dao/NoteDao;", "add", "", "note", "Lru/freeit/notes/domain/entity/Note;", "(Lru/freeit/notes/domain/entity/Note;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "noteBy", "noteId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notesBy", "", "sortingType", "Lru/freeit/notes/domain/repository/SortingType;", "(Lru/freeit/notes/domain/repository/SortingType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "", "update", "app_debug"})
public final class NoteRepositoryImpl implements ru.freeit.notes.domain.repository.NoteRepository {
    private final kotlinx.coroutines.CoroutineDispatcher dispatcher = null;
    private final ru.freeit.notes.data.db.dao.NoteDao noteDao = null;
    
    public NoteRepositoryImpl(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.data.db.AppDatabase appDatabase, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object notesBy(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.repository.SortingType sortingType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<ru.freeit.notes.domain.entity.Note>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object add(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.entity.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object noteBy(long noteId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super ru.freeit.notes.domain.entity.Note> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object remove(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.entity.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object update(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.domain.entity.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}