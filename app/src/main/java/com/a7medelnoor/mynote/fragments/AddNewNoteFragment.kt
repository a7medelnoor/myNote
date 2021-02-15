package com.a7medelnoor.mynote.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a7medelnoor.mynote.MainActivity
import com.a7medelnoor.mynote.R
import com.a7medelnoor.mynote.databinding.FragmentHomeBinding
import com.a7medelnoor.mynote.viewmodel.NoteViewModel

/***
 *  Note Android Application
 *  Created By: Ahmed Elnoor
 *  www.github.com/a7medelnoor
 */
class AddNewNoteFragment : Fragment(R.layout.fragment_add_new_note) {
    private var _bindingAddNewFragment: FragmentHomeBinding? = null
    private val bindingAddNewFragment get() = _bindingAddNewFragment!!
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var mView: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = (activity as MainActivity).noteViewModel
        mView = view
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for Home fragment
        _bindingAddNewFragment = FragmentHomeBinding.inflate(
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