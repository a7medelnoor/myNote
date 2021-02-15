package com.a7medelnoor.mynote.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.mynote.databinding.NoteLayoutAdapterBinding
import com.a7medelnoor.mynote.model.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolderAdapter>() {
    private var bindingAdapter: NoteLayoutAdapterBinding? = null

    class NoteViewHolderAdapter(itemBinding: NoteLayoutAdapterBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    private val differCallBack =
        object : DiffUtil.ItemCallback<Note>(){
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
             return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem == newItem
            }

        }
    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolderAdapter {
      bindingAdapter = NoteLayoutAdapterBinding.inflate(
          LayoutInflater.from(parent.context),
          parent,
          false
      )
        return NoteViewHolderAdapter(bindingAdapter!!)
    }

    override fun onBindViewHolder(holder: NoteViewHolderAdapter, position: Int) {
       // get current note by position
        val currentNote  = differ.currentList[position]
        holder.itemView.apply {
            // bind the view
            bindingAdapter?.noteTitleTextView?.text = currentNote.noteTitleName
            bindingAdapter?.noteBodyTextView?.text = currentNote.noteBody
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}