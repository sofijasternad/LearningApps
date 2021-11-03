package ru.freeit.notes.presentation.screens.notes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0010\u0011B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lru/freeit/notes/presentation/screens/notes/NotesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/freeit/notes/domain/entity/Note;", "Lru/freeit/notes/presentation/screens/notes/NotesAdapter$NotesViewHolder;", "callback", "Lru/freeit/notes/presentation/screens/notes/NoteListItemCallback;", "(Lru/freeit/notes/presentation/screens/notes/NoteListItemCallback;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "NoteDiffUtilCallback", "NotesViewHolder", "app_debug"})
public final class NotesAdapter extends androidx.recyclerview.widget.ListAdapter<ru.freeit.notes.domain.entity.Note, ru.freeit.notes.presentation.screens.notes.NotesAdapter.NotesViewHolder> {
    private ru.freeit.notes.presentation.screens.notes.NoteListItemCallback callback;
    
    public NotesAdapter(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.presentation.screens.notes.NoteListItemCallback callback) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ru.freeit.notes.presentation.screens.notes.NotesAdapter.NotesViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    ru.freeit.notes.presentation.screens.notes.NotesAdapter.NotesViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lru/freeit/notes/presentation/screens/notes/NotesAdapter$NoteDiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/freeit/notes/domain/entity/Note;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class NoteDiffUtilCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<ru.freeit.notes.domain.entity.Note> {
        
        public NoteDiffUtilCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        ru.freeit.notes.domain.entity.Note oldItem, @org.jetbrains.annotations.NotNull()
        ru.freeit.notes.domain.entity.Note newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        ru.freeit.notes.domain.entity.Note oldItem, @org.jetbrains.annotations.NotNull()
        ru.freeit.notes.domain.entity.Note newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lru/freeit/notes/presentation/screens/notes/NotesAdapter$NotesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/freeit/notes/databinding/NoteListItemBinding;", "(Lru/freeit/notes/databinding/NoteListItemBinding;)V", "bind", "", "note", "Lru/freeit/notes/domain/entity/Note;", "callback", "Lru/freeit/notes/presentation/screens/notes/NoteListItemCallback;", "Companion", "app_debug"})
    public static final class NotesViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final ru.freeit.notes.databinding.NoteListItemBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        public static final ru.freeit.notes.presentation.screens.notes.NotesAdapter.NotesViewHolder.Companion Companion = null;
        
        public NotesViewHolder(@org.jetbrains.annotations.NotNull()
        ru.freeit.notes.databinding.NoteListItemBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        ru.freeit.notes.domain.entity.Note note, @org.jetbrains.annotations.NotNull()
        ru.freeit.notes.presentation.screens.notes.NoteListItemCallback callback) {
        }
        
        @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lru/freeit/notes/presentation/screens/notes/NotesAdapter$NotesViewHolder$Companion;", "", "()V", "from", "Lru/freeit/notes/presentation/screens/notes/NotesAdapter$NotesViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ru.freeit.notes.presentation.screens.notes.NotesAdapter.NotesViewHolder from(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
        }
    }
}