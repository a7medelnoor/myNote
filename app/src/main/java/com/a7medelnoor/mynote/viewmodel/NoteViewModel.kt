package com.a7medelnoor.mynote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a7medelnoor.mynote.model.Note
import com.a7medelnoor.mynote.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(
    app: Application,
    private val noteRepository: NoteRepository
):AndroidViewModel(app) {

     // add note
    fun addNoteToDatabase(note: Note) = viewModelScope.launch {
        noteRepository.addNoteToDatabase(note)
    }
    // update note
    fun updateNoteToDatabase(note: Note) = viewModelScope.launch {
        noteRepository.updateNoteToDatabase(note)
    }
    // delete note
    fun deleteNoteFormDatabase(note: Note) = viewModelScope.launch {
        noteRepository.deleteNoteFromDatabase(note)
    }
    // get all notes form database
    fun getAllNotesFormDatabase() = noteRepository.getAllNotesFromDataBase()

}