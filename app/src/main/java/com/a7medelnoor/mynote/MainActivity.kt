package com.a7medelnoor.mynote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.a7medelnoor.mynote.data.NoteDatabaseInstance
import com.a7medelnoor.mynote.databinding.ActivityMainBinding
import com.a7medelnoor.mynote.repository.NoteRepository
import com.a7medelnoor.mynote.viewmodel.NoteViewModel
import com.a7medelnoor.mynote.viewmodel.NoteViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        // setup toolbar
        setSupportActionBar(mainBinding.toolbar)
        // setup note view model
        setupNoteViewModel()
    }

    private fun setupNoteViewModel() {
        val noteRepository = NoteRepository(
            NoteDatabaseInstance(this)
        )
        val noteViewModelProviderFactory =
            NoteViewModelProviderFactory(
                application,
                noteRepository
            )

        noteViewModel = ViewModelProvider(
            this,
            noteViewModelProviderFactory
        ).get(NoteViewModel::class.java)
    }
}