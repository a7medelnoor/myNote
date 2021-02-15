package com.a7medelnoor.mynote.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.a7medelnoor.mynote.MainActivity
import com.a7medelnoor.mynote.R
import com.a7medelnoor.mynote.databinding.FragmentAddNewNoteBinding
import com.a7medelnoor.mynote.databinding.FragmentHomeBinding
import com.a7medelnoor.mynote.model.Note
import com.a7medelnoor.mynote.toast
import com.a7medelnoor.mynote.viewmodel.NoteViewModel

/***
 *  Note Android Application
 *  Created By: Ahmed Elnoor
 *  www.github.com/a7medelnoor
 */
class AddNewNoteFragment : Fragment(R.layout.fragment_add_new_note) {
    private var _bindingAddNewFragment: FragmentAddNewNoteBinding? = null
    private val bindingAddNewFragment get() = _bindingAddNewFragment!!
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var mView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = (activity as MainActivity).noteViewModel
        mView = view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.save_note_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.save_menu_id -> {
             saveNewNote(mView)
            }
        }
        return super.onOptionsItemSelected(item)
    }
private fun saveNewNote(view: View){
   val newNoteTitle = bindingAddNewFragment.noteTitleEditText.text.toString().trim()
    val newNoteBody = bindingAddNewFragment.noteBodyEditText.text.toString().trim()
    if (newNoteTitle.isNotEmpty()){
        val note = Note(0,newNoteTitle, newNoteBody)
        noteViewModel.addNoteToDatabase(note)
        activity?.toast("note saved successfully")
    }else {
        activity?.toast("Note Title should not be empty")
    }
}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for Home fragment
        _bindingAddNewFragment = FragmentAddNewNoteBinding.inflate(
                inflater,
                container,
                false
        )
        return bindingAddNewFragment.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _bindingAddNewFragment = null
    }
}