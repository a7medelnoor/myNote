package com.a7medelnoor.mynote.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a7medelnoor.mynote.repository.NoteRepository

class NoteViewModelProviderFactory (
     val app:Application,
    private val noteRepository: NoteRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(app,noteRepository ) as T
    }
}