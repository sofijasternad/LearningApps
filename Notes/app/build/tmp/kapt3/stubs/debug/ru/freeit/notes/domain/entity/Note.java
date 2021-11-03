package ru.freeit.notes.domain.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\n\u001a\u00020\u0005H\u00c2\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c2\u0003J1\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lru/freeit/notes/domain/entity/Note;", "", "id", "", "title", "", "createdDate", "editedDate", "(JLjava/lang/String;JJ)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "lastEdited", "toDb", "Lru/freeit/notes/data/db/entity/Note;", "toString", "app_debug"})
public final class Note {
    private final long id = 0L;
    private final java.lang.String title = null;
    private final long createdDate = 0L;
    private final long editedDate = 0L;
    
    @org.jetbrains.annotations.NotNull()
    public final ru.freeit.notes.domain.entity.Note copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, long createdDate, long editedDate) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Note() {
        super();
    }
    
    public Note(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, long createdDate, long editedDate) {
        super();
    }
    
    private final long component1() {
        return 0L;
    }
    
    private final java.lang.String component2() {
        return null;
    }
    
    private final long component3() {
        return 0L;
    }
    
    private final long component4() {
        return 0L;
    }
    
    public final long id() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String title() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String lastEdited() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.freeit.notes.data.db.entity.Note toDb() {
        return null;
    }
}