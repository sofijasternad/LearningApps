package ru.freeit.notes.data.db.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.collection.LongSparseArray;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import ru.freeit.notes.data.db.entity.Note;
import ru.freeit.notes.data.db.entity.NoteWithTags;
import ru.freeit.notes.data.db.entity.Tag;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NoteDao_Impl implements NoteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Note> __insertionAdapterOfNote;

  private final EntityDeletionOrUpdateAdapter<Note> __deletionAdapterOfNote;

  private final EntityDeletionOrUpdateAdapter<Note> __updateAdapterOfNote;

  public NoteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNote = new EntityInsertionAdapter<Note>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `notes` (`title`,`created_date`,`edited_date`,`id`) VALUES (?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Note value) {
        if (value.getTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitle());
        }
        stmt.bindLong(2, value.getCreatedDate());
        stmt.bindLong(3, value.getEditedDate());
        stmt.bindLong(4, value.getId());
      }
    };
    this.__deletionAdapterOfNote = new EntityDeletionOrUpdateAdapter<Note>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `notes` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Note value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfNote = new EntityDeletionOrUpdateAdapter<Note>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `notes` SET `title` = ?,`created_date` = ?,`edited_date` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Note value) {
        if (value.getTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitle());
        }
        stmt.bindLong(2, value.getCreatedDate());
        stmt.bindLong(3, value.getEditedDate());
        stmt.bindLong(4, value.getId());
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public Object add(final Note note, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfNote.insertAndReturnId(note);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object remove(final Note note, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfNote.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final Note note, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfNote.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object notesByCreatedDate(final Continuation<? super List<NoteWithTags>> continuation) {
    final String _sql = "select * from notes order by created_date";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, true, _cancellationSignal, new Callable<List<NoteWithTags>>() {
      @Override
      public List<NoteWithTags> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
            final int _cursorIndexOfCreatedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "created_date");
            final int _cursorIndexOfEditedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "edited_date");
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final LongSparseArray<ArrayList<Tag>> _collectionTags = new LongSparseArray<ArrayList<Tag>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
              ArrayList<Tag> _tmpTagsCollection = _collectionTags.get(_tmpKey);
              if (_tmpTagsCollection == null) {
                _tmpTagsCollection = new ArrayList<Tag>();
                _collectionTags.put(_tmpKey, _tmpTagsCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiptagsAsruFreeitNotesDataDbEntityTag(_collectionTags);
            final List<NoteWithTags> _result = new ArrayList<NoteWithTags>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final NoteWithTags _item;
              final Note _tmpNote;
              if (! (_cursor.isNull(_cursorIndexOfTitle) && _cursor.isNull(_cursorIndexOfCreatedDate) && _cursor.isNull(_cursorIndexOfEditedDate) && _cursor.isNull(_cursorIndexOfId))) {
                final String _tmpTitle;
                if (_cursor.isNull(_cursorIndexOfTitle)) {
                  _tmpTitle = null;
                } else {
                  _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
                }
                final long _tmpCreatedDate;
                _tmpCreatedDate = _cursor.getLong(_cursorIndexOfCreatedDate);
                final long _tmpEditedDate;
                _tmpEditedDate = _cursor.getLong(_cursorIndexOfEditedDate);
                final long _tmpId;
                _tmpId = _cursor.getLong(_cursorIndexOfId);
                _tmpNote = new Note(_tmpTitle,_tmpCreatedDate,_tmpEditedDate,_tmpId);
              }  else  {
                _tmpNote = null;
              }
              ArrayList<Tag> _tmpTagsCollection_1 = null;
              final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpTagsCollection_1 = _collectionTags.get(_tmpKey_1);
              if (_tmpTagsCollection_1 == null) {
                _tmpTagsCollection_1 = new ArrayList<Tag>();
              }
              _item = new NoteWithTags(_tmpNote,_tmpTagsCollection_1);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
            _statement.release();
          }
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object notesByEditedDate(final Continuation<? super List<NoteWithTags>> continuation) {
    final String _sql = "select * from notes order by edited_date";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, true, _cancellationSignal, new Callable<List<NoteWithTags>>() {
      @Override
      public List<NoteWithTags> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
            final int _cursorIndexOfCreatedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "created_date");
            final int _cursorIndexOfEditedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "edited_date");
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final LongSparseArray<ArrayList<Tag>> _collectionTags = new LongSparseArray<ArrayList<Tag>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
              ArrayList<Tag> _tmpTagsCollection = _collectionTags.get(_tmpKey);
              if (_tmpTagsCollection == null) {
                _tmpTagsCollection = new ArrayList<Tag>();
                _collectionTags.put(_tmpKey, _tmpTagsCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiptagsAsruFreeitNotesDataDbEntityTag(_collectionTags);
            final List<NoteWithTags> _result = new ArrayList<NoteWithTags>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final NoteWithTags _item;
              final Note _tmpNote;
              if (! (_cursor.isNull(_cursorIndexOfTitle) && _cursor.isNull(_cursorIndexOfCreatedDate) && _cursor.isNull(_cursorIndexOfEditedDate) && _cursor.isNull(_cursorIndexOfId))) {
                final String _tmpTitle;
                if (_cursor.isNull(_cursorIndexOfTitle)) {
                  _tmpTitle = null;
                } else {
                  _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
                }
                final long _tmpCreatedDate;
                _tmpCreatedDate = _cursor.getLong(_cursorIndexOfCreatedDate);
                final long _tmpEditedDate;
                _tmpEditedDate = _cursor.getLong(_cursorIndexOfEditedDate);
                final long _tmpId;
                _tmpId = _cursor.getLong(_cursorIndexOfId);
                _tmpNote = new Note(_tmpTitle,_tmpCreatedDate,_tmpEditedDate,_tmpId);
              }  else  {
                _tmpNote = null;
              }
              ArrayList<Tag> _tmpTagsCollection_1 = null;
              final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpTagsCollection_1 = _collectionTags.get(_tmpKey_1);
              if (_tmpTagsCollection_1 == null) {
                _tmpTagsCollection_1 = new ArrayList<Tag>();
              }
              _item = new NoteWithTags(_tmpNote,_tmpTagsCollection_1);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
            _statement.release();
          }
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object notesByTitle(final Continuation<? super List<NoteWithTags>> continuation) {
    final String _sql = "select * from notes order by title";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, true, _cancellationSignal, new Callable<List<NoteWithTags>>() {
      @Override
      public List<NoteWithTags> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
            final int _cursorIndexOfCreatedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "created_date");
            final int _cursorIndexOfEditedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "edited_date");
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final LongSparseArray<ArrayList<Tag>> _collectionTags = new LongSparseArray<ArrayList<Tag>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
              ArrayList<Tag> _tmpTagsCollection = _collectionTags.get(_tmpKey);
              if (_tmpTagsCollection == null) {
                _tmpTagsCollection = new ArrayList<Tag>();
                _collectionTags.put(_tmpKey, _tmpTagsCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiptagsAsruFreeitNotesDataDbEntityTag(_collectionTags);
            final List<NoteWithTags> _result = new ArrayList<NoteWithTags>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final NoteWithTags _item;
              final Note _tmpNote;
              if (! (_cursor.isNull(_cursorIndexOfTitle) && _cursor.isNull(_cursorIndexOfCreatedDate) && _cursor.isNull(_cursorIndexOfEditedDate) && _cursor.isNull(_cursorIndexOfId))) {
                final String _tmpTitle;
                if (_cursor.isNull(_cursorIndexOfTitle)) {
                  _tmpTitle = null;
                } else {
                  _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
                }
                final long _tmpCreatedDate;
                _tmpCreatedDate = _cursor.getLong(_cursorIndexOfCreatedDate);
                final long _tmpEditedDate;
                _tmpEditedDate = _cursor.getLong(_cursorIndexOfEditedDate);
                final long _tmpId;
                _tmpId = _cursor.getLong(_cursorIndexOfId);
                _tmpNote = new Note(_tmpTitle,_tmpCreatedDate,_tmpEditedDate,_tmpId);
              }  else  {
                _tmpNote = null;
              }
              ArrayList<Tag> _tmpTagsCollection_1 = null;
              final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpTagsCollection_1 = _collectionTags.get(_tmpKey_1);
              if (_tmpTagsCollection_1 == null) {
                _tmpTagsCollection_1 = new ArrayList<Tag>();
              }
              _item = new NoteWithTags(_tmpNote,_tmpTagsCollection_1);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
            _statement.release();
          }
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object notes(final Continuation<? super List<NoteWithTags>> continuation) {
    final String _sql = "select * from notes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, true, _cancellationSignal, new Callable<List<NoteWithTags>>() {
      @Override
      public List<NoteWithTags> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
            final int _cursorIndexOfCreatedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "created_date");
            final int _cursorIndexOfEditedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "edited_date");
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final LongSparseArray<ArrayList<Tag>> _collectionTags = new LongSparseArray<ArrayList<Tag>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
              ArrayList<Tag> _tmpTagsCollection = _collectionTags.get(_tmpKey);
              if (_tmpTagsCollection == null) {
                _tmpTagsCollection = new ArrayList<Tag>();
                _collectionTags.put(_tmpKey, _tmpTagsCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiptagsAsruFreeitNotesDataDbEntityTag(_collectionTags);
            final List<NoteWithTags> _result = new ArrayList<NoteWithTags>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final NoteWithTags _item;
              final Note _tmpNote;
              if (! (_cursor.isNull(_cursorIndexOfTitle) && _cursor.isNull(_cursorIndexOfCreatedDate) && _cursor.isNull(_cursorIndexOfEditedDate) && _cursor.isNull(_cursorIndexOfId))) {
                final String _tmpTitle;
                if (_cursor.isNull(_cursorIndexOfTitle)) {
                  _tmpTitle = null;
                } else {
                  _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
                }
                final long _tmpCreatedDate;
                _tmpCreatedDate = _cursor.getLong(_cursorIndexOfCreatedDate);
                final long _tmpEditedDate;
                _tmpEditedDate = _cursor.getLong(_cursorIndexOfEditedDate);
                final long _tmpId;
                _tmpId = _cursor.getLong(_cursorIndexOfId);
                _tmpNote = new Note(_tmpTitle,_tmpCreatedDate,_tmpEditedDate,_tmpId);
              }  else  {
                _tmpNote = null;
              }
              ArrayList<Tag> _tmpTagsCollection_1 = null;
              final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpTagsCollection_1 = _collectionTags.get(_tmpKey_1);
              if (_tmpTagsCollection_1 == null) {
                _tmpTagsCollection_1 = new ArrayList<Tag>();
              }
              _item = new NoteWithTags(_tmpNote,_tmpTagsCollection_1);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
            _statement.release();
          }
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object noteBy(final long id, final Continuation<? super NoteWithTags> continuation) {
    final String _sql = "select * from notes where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, true, _cancellationSignal, new Callable<NoteWithTags>() {
      @Override
      public NoteWithTags call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
            final int _cursorIndexOfCreatedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "created_date");
            final int _cursorIndexOfEditedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "edited_date");
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final LongSparseArray<ArrayList<Tag>> _collectionTags = new LongSparseArray<ArrayList<Tag>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
              ArrayList<Tag> _tmpTagsCollection = _collectionTags.get(_tmpKey);
              if (_tmpTagsCollection == null) {
                _tmpTagsCollection = new ArrayList<Tag>();
                _collectionTags.put(_tmpKey, _tmpTagsCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiptagsAsruFreeitNotesDataDbEntityTag(_collectionTags);
            final NoteWithTags _result;
            if(_cursor.moveToFirst()) {
              final Note _tmpNote;
              if (! (_cursor.isNull(_cursorIndexOfTitle) && _cursor.isNull(_cursorIndexOfCreatedDate) && _cursor.isNull(_cursorIndexOfEditedDate) && _cursor.isNull(_cursorIndexOfId))) {
                final String _tmpTitle;
                if (_cursor.isNull(_cursorIndexOfTitle)) {
                  _tmpTitle = null;
                } else {
                  _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
                }
                final long _tmpCreatedDate;
                _tmpCreatedDate = _cursor.getLong(_cursorIndexOfCreatedDate);
                final long _tmpEditedDate;
                _tmpEditedDate = _cursor.getLong(_cursorIndexOfEditedDate);
                final long _tmpId;
                _tmpId = _cursor.getLong(_cursorIndexOfId);
                _tmpNote = new Note(_tmpTitle,_tmpCreatedDate,_tmpEditedDate,_tmpId);
              }  else  {
                _tmpNote = null;
              }
              ArrayList<Tag> _tmpTagsCollection_1 = null;
              final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpTagsCollection_1 = _collectionTags.get(_tmpKey_1);
              if (_tmpTagsCollection_1 == null) {
                _tmpTagsCollection_1 = new ArrayList<Tag>();
              }
              _result = new NoteWithTags(_tmpNote,_tmpTagsCollection_1);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
            _statement.release();
          }
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshiptagsAsruFreeitNotesDataDbEntityTag(
      final LongSparseArray<ArrayList<Tag>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<ArrayList<Tag>> _tmpInnerMap = new LongSparseArray<ArrayList<Tag>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshiptagsAsruFreeitNotesDataDbEntityTag(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<ArrayList<Tag>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshiptagsAsruFreeitNotesDataDbEntityTag(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `title`,`note_id`,`id` FROM `tags` WHERE `note_id` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "note_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfNoteId = CursorUtil.getColumnIndexOrThrow(_cursor, "note_id");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      while(_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_itemKeyIndex);
        ArrayList<Tag> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final Tag _item_1;
          final String _tmpTitle;
          if (_cursor.isNull(_cursorIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
          }
          final long _tmpNoteId;
          _tmpNoteId = _cursor.getLong(_cursorIndexOfNoteId);
          final long _tmpId;
          _tmpId = _cursor.getLong(_cursorIndexOfId);
          _item_1 = new Tag(_tmpTitle,_tmpNoteId,_tmpId);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
