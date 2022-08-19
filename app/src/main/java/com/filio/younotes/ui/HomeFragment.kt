package com.filio.younotes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.filio.younotes.MockData
import com.filio.younotes.R
import com.filio.younotes.databinding.FragmentFirstBinding

class HomeFragment : Fragment() {

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

        binding.fabAddNote.setOnClickListener {
            AddNoteDialogFragment.display(childFragmentManager)
        }

        handleAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleAdapter() = with(binding) {
        val adapter = NotesAdapter {}

        binding.recNotes.adapter = adapter

        adapter.submitList(MockData.getNotes(15, requireContext()))
    }
}