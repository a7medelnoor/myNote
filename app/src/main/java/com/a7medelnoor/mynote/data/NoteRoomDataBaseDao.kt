package com.a7medelnoor.mynote.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.a7medelnoor.mynote.model.Note

@Dao
interface NoteRoomDataBaseDao {

    // add note
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun  addNoteToDatabase(note: Note)
    // update note
    @Update
    suspend fun updateNoteDatabase(note: Note)
    // delete note
    @Delete
    suspend fun deleteNoteFormDatabase(note: Note)
    // getAll notes
     @Query("SELECT * FROM noteTable ORDER BY id DESC")
    fun getAllNotesFromDataBase(): LiveData<List<Note>>

}