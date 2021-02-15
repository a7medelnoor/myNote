package com.a7medelnoor.mynote.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a7medelnoor.mynote.R
import com.a7medelnoor.mynote.databinding.FragmentHomeBinding

/***
 *  Note Android Application
 *  Created By: Ahmed Elnoor
 *  www.github.com/a7medelnoor
 */
class AddNewNoteFragment : Fragment(R.layout.fragment_add_new_note) {
    private var _bindingAddNewFragment : FragmentHomeBinding? =null
    private val bindingAddNewFragment get() = _bindingAddNewFragment!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

}