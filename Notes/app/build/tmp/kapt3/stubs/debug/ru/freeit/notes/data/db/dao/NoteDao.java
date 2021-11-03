package ru.freeit.notes.data.db.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lru/freeit/notes/data/db/dao/NoteDao;", "", "add", "", "note", "Lru/freeit/notes/data/db/entity/Note;", "(Lru/freeit/notes/data/db/entity/Note;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "noteBy", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notes", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notesByCreatedDate", "notesByEditedDate", "notesByTitle", "remove", "update", "app_debug"})
public abstract interface NoteDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from notes order by created_date")
    public abstract java.lang.Object notesByCreatedDate(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<ru.freeit.notes.data.db.entity.Note>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from notes order by edited_date")
    public abstract java.lang.Object notesByEditedDate(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<ru.freeit.notes.data.db.entity.Note>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from notes order by title")
    public abstract java.lang.Object notesByTitle(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<ru.freeit.notes.data.db.entity.Note>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from notes")
    public abstract java.lang.Object notes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<ru.freeit.notes.data.db.entity.Note>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from notes where id = :id")
    public abstract java.lang.Object noteBy(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super ru.freeit.notes.data.db.entity.Note> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object add(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.data.db.entity.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object remove(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.data.db.entity.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.data.db.entity.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}