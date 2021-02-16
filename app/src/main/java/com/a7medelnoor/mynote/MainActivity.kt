package com.a7medelnoor.mynote

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
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
        mainBinding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    true
                }
            }
            true
        }
        // pass two strings open/close as an arguments to the ActionBarDrawerToggle
        val drawerToggle = ActionBarDrawerToggle(this, mainBinding.drawerLayout, R.string.open, R.string.close)
        // add drawer listener
        mainBinding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // setup note view model
        setupNoteViewModel()

    }

    override fun onBackPressed() {
        if (mainBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mainBinding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            android.R.id.home -> {
                mainBinding.drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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