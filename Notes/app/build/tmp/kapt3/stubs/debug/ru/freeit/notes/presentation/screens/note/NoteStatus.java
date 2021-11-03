package ru.freeit.notes.presentation.screens.note;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lru/freeit/notes/presentation/screens/note/NoteStatus;", "", "()V", "AlreadyAdded", "SuccessAdded", "SuccessEdited", "TitleEmpty", "Lru/freeit/notes/presentation/screens/note/NoteStatus$SuccessAdded;", "Lru/freeit/notes/presentation/screens/note/NoteStatus$SuccessEdited;", "Lru/freeit/notes/presentation/screens/note/NoteStatus$TitleEmpty;", "Lru/freeit/notes/presentation/screens/note/NoteStatus$AlreadyAdded;", "app_debug"})
public abstract class NoteStatus {
    
    private NoteStatus() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/freeit/notes/presentation/screens/note/NoteStatus$SuccessAdded;", "Lru/freeit/notes/presentation/screens/note/NoteStatus;", "()V", "app_debug"})
    public static final class SuccessAdded extends ru.freeit.notes.presentation.screens.note.NoteStatus {
        @org.jetbrains.annotations.NotNull()
        public static final ru.freeit.notes.presentation.screens.note.NoteStatus.SuccessAdded INSTANCE = null;
        
        private SuccessAdded() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/freeit/notes/presentation/screens/note/NoteStatus$SuccessEdited;", "Lru/freeit/notes/presentation/screens/note/NoteStatus;", "()V", "app_debug"})
    public static final class SuccessEdited extends ru.freeit.notes.presentation.screens.note.NoteStatus {
        @org.jetbrains.annotations.NotNull()
        public static final ru.freeit.notes.presentation.screens.note.NoteStatus.SuccessEdited INSTANCE = null;
        
        private SuccessEdited() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/freeit/notes/presentation/screens/note/NoteStatus$TitleEmpty;", "Lru/freeit/notes/presentation/screens/note/NoteStatus;", "()V", "app_debug"})
    public static final class TitleEmpty extends ru.freeit.notes.presentation.screens.note.NoteStatus {
        @org.jetbrains.annotations.NotNull()
        public static final ru.freeit.notes.presentation.screens.note.NoteStatus.TitleEmpty INSTANCE = null;
        
        private TitleEmpty() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003H\u00c2\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u00d6\u0003J\t\u0010\u000b\u001a\u00020\fH\u00d6\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lru/freeit/notes/presentation/screens/note/NoteStatus$AlreadyAdded;", "Lru/freeit/notes/presentation/screens/note/NoteStatus;", "note", "Lru/freeit/notes/domain/entity/Note;", "(Lru/freeit/notes/domain/entity/Note;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "title", "", "toString", "app_debug"})
    public static final class AlreadyAdded extends ru.freeit.notes.presentation.screens.note.NoteStatus {
        private final ru.freeit.notes.domain.entity.Note note = null;
        
        @org.jetbrains.annotations.NotNull()
        public final ru.freeit.notes.presentation.screens.note.NoteStatus.AlreadyAdded copy(@org.jetbrains.annotations.NotNull()
        ru.freeit.notes.domain.entity.Note note) {
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
        
        public AlreadyAdded(@org.jetbrains.annotations.NotNull()
        ru.freeit.notes.domain.entity.Note note) {
            super();
        }
        
        private final ru.freeit.notes.domain.entity.Note component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String title() {
            return null;
        }
    }
}