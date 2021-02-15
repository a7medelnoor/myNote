package com.a7medelnoor.mynote.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.a7medelnoor.mynote.MainActivity
import com.a7medelnoor.mynote.R
import com.a7medelnoor.mynote.adapter.NoteAdapter
import com.a7medelnoor.mynote.databinding.FragmentHomeBinding
import com.a7medelnoor.mynote.model.Note
import com.a7medelnoor.mynote.viewmodel.NoteViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _fragmentHomeBinding: FragmentHomeBinding? = null
    private val fragmentHomeBinding get() = _fragmentHomeBinding!!
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter

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
        return fragmentHomeBinding.root
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
        // bind view of fab button and handle onCLick listener
        fragmentHomeBinding.fabAddNote.setOnClickListener{ mView ->
          mView.findNavController().navigate(R.id.action_homeFragment_to_addNewNoteFragment)
        }
    }

    private fun setupNoteRecyclerView() {
        noteAdapter = NoteAdapter()
        fragmentHomeBinding.noteRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(
                    2,
                    StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
            adapter = noteAdapter
        }
        activity?.let {
           noteViewModel.getAllNotesFormDatabase().observe(viewLifecycleOwner, { getAllNotes ->
               noteAdapter.differ.submitList(getAllNotes)
               updateHomeNoteFragment(getAllNotes)
           })
        }
    }

    private fun updateHomeNoteFragment(allNotes: List<Note>) {
             if (allNotes.isNotEmpty()){
                 fragmentHomeBinding.noteRecyclerView.visibility = View.VISIBLE
                 fragmentHomeBinding.noNoteAvailabel.visibility = View.GONE
             }else{
                 fragmentHomeBinding.noteRecyclerView.visibility = View.GONE
                 fragmentHomeBinding.noNoteAvailabel.visibility = View.VISIBLE
             }
    }

}