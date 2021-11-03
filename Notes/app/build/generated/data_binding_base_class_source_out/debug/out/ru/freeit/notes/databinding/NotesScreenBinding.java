// Generated by view binder compiler. Do not edit!
package ru.freeit.notes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.freeit.notes.R;

public final class NotesScreenBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final FloatingActionButton addNoteButton;

  @NonNull
  public final RecyclerView noteList;

  private NotesScreenBinding(@NonNull FrameLayout rootView,
      @NonNull FloatingActionButton addNoteButton, @NonNull RecyclerView noteList) {
    this.rootView = rootView;
    this.addNoteButton = addNoteButton;
    this.noteList = noteList;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static NotesScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static NotesScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.notes_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static NotesScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_note_button;
      FloatingActionButton addNoteButton = ViewBindings.findChildViewById(rootView, id);
      if (addNoteButton == null) {
        break missingId;
      }

      id = R.id.note_list;
      RecyclerView noteList = ViewBindings.findChildViewById(rootView, id);
      if (noteList == null) {
        break missingId;
      }

      return new NotesScreenBinding((FrameLayout) rootView, addNoteButton, noteList);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
