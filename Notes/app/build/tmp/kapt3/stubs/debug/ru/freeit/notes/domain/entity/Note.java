package ru.freeit.notes.domain.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\f\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c2\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c2\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c2\u0003JA\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0005J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lru/freeit/notes/domain/entity/Note;", "", "id", "", "title", "", "createdDate", "editedDate", "tags", "", "Lru/freeit/notes/domain/entity/Tag;", "(JLjava/lang/String;JJLjava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "lastEdited", "tagsString", "toDb", "Lru/freeit/notes/data/db/entity/Note;", "toString", "app_debug"})
public final class Note {
    private final long id = 0L;
    private final java.lang.String title = null;
    private final long createdDate = 0L;
    private final long editedDate = 0L;
    private final java.util.List<ru.freeit.notes.domain.entity.Tag> tags = null;
    
    @org.jetbrains.annotations.NotNull()
    public final ru.freeit.notes.domain.entity.Note copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, long createdDate, long editedDate, @org.jetbrains.annotations.NotNull()
    java.util.List<ru.freeit.notes.domain.entity.Tag> tags) {
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
    java.lang.String title, long createdDate, long editedDate, @org.jetbrains.annotations.NotNull()
    java.util.List<ru.freeit.notes.domain.entity.Tag> tags) {
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
    
    private final java.util.List<ru.freeit.notes.domain.entity.Tag> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String tagsString() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ru.freeit.notes.domain.entity.Tag> tags() {
        return null;
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