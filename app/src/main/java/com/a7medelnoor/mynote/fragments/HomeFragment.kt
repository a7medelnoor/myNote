package com.a7medelnoor.mynote.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.a7medelnoor.mynote.MainActivity
import com.a7medelnoor.mynote.R
import com.a7medelnoor.mynote.databinding.FragmentHomeBinding
import com.a7medelnoor.mynote.toast
import com.a7medelnoor.mynote.viewmodel.NoteViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _fragmentHomeBinding: FragmentHomeBinding? = null
    private val binding get() = _fragmentHomeBinding!!
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _fragmentHomeBinding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentHomeBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = (activity as MainActivity).noteViewModel
        // setupNoteRecyclerView
        setupNoteRecyclerView()
        // add button configuration
        binding.fabAddNote.setOnClickListener{mView ->
           activity?.toast("Button clicked")
        }
    }

    private fun setupNoteRecyclerView() {

    }
}