package com.filio.younotes.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.filio.younotes.data.NoteItemUI
import com.filio.younotes.databinding.ItemNoteBinding


class NotesAdapter(val listener: (NoteItemUI) -> Unit) : ListAdapter<NoteItemUI, NotesAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.ViewHolder {

        val itemBinding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NotesAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val setting = getItem(adapterPosition)
                listener.invoke(setting)
            }
        }

        fun bind(item: NoteItemUI) = with(binding) {
            txtTitle.text = item.title
            txtBody.text = item.message + "..."
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<NoteItemUI>() {
        override fun areItemsTheSame(oldItem: NoteItemUI, newItem: NoteItemUI): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: NoteItemUI, newItem: NoteItemUI): Boolean = oldItem == newItem
    }
}