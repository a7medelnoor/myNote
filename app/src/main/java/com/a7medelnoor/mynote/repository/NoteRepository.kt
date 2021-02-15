package com.a7medelnoor.mynote.repository

import com.a7medelnoor.mynote.data.NoteDatabaseInstance
import com.a7medelnoor.mynote.model.Note

class NoteRepository(private val noteDatabaseInstance: NoteDatabaseInstance){
    // add note
    suspend fun addNoteToDatabase(note: Note) = noteDatabaseInstance.getNoteRoomDataBaseDao().addNoteToDatabase(note)
    // update note
    suspend fun updateNoteToDatabase(note: Note) = noteDatabaseInstance.getNoteRoomDataBaseDao().updateNoteDatabase(note)
    // delete note
    suspend fun deleteNoteFromDatabase(note: Note) = noteDatabaseInstance.getNoteRoomDataBaseDao().deleteNoteFormDatabase(note)
    // get all note
    fun getAllNotesFromDataBase()= noteDatabaseInstance.getNoteRoomDataBaseDao().getAllNotesFromDataBase()
}