package com.filio.younotes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.filio.younotes.R
import com.filio.younotes.data.NoteItemUI
import com.filio.younotes.databinding.FragmentFirstBinding
import com.filio.younotes.db.NotesDao
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject lateinit var dao: NotesDao
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.title = getString(R.string.your_notes)

        binding.fabSaveNote.setOnClickListener {
            AddNoteDialogFragment.display(childFragmentManager)
        }

        handleAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleAdapter() = with(binding) {
        val adapter = NotesAdapter {
            AddNoteDialogFragment.display(childFragmentManager, it)
        }

        binding.recNotes.adapter = adapter

        lifecycleScope.launch {
            dao.fetchAllNotes().collectLatest { notesItemDBList ->
                /**
                 * Convert list on NoteItemDB to list of NoteItemUI
                 * */
                val notesItemUIList = notesItemDBList.map {
                    NoteItemUI(
                        id = it.id,
                        title = it.title,
                        message = it.message,
                        createdAt = it.createdAt,
                        editedAt = it.editedAt
                    )
                }

                adapter.submitList(notesItemUIList)
            }
        }
    }
}