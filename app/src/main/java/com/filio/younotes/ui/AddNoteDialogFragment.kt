package com.filio.younotes.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.filio.younotes.R
import com.filio.younotes.data.NoteItemUI
import com.filio.younotes.databinding.ExampleDialogBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddNoteDialogFragment : DialogFragment() {

    private var _binding: ExampleDialogBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<NotesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog)
    }

    /** The system calls this to get the DialogFragment's layout, regardless
    of whether it's being displayed as a dialog or an embedded fragment. */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = ExampleDialogBinding.inflate(LayoutInflater.from(context))

        return binding.root
    }

    /** The system calls this only when creating the layout in a dialog. */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window!!.setLayout(width, height)
            dialog.window!!.setWindowAnimations(R.style.AppTheme_Slide);
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationOnClickListener { dismiss() }

        handleViews()

        handleViewModel()
    }

    private fun handleViews() {
        val note = arguments?.getParcelable<NoteItemUI>("note")

        if (note == null) {
            createNoteFlow()
        } else {
            readNoteFlow(note)
        }
    }

    private fun createNoteFlow() {
        binding.toolbar.title = getString(R.string.add_note)

        binding.fabDeleteNote.isVisible = false

        binding.fabAddNote.setOnClickListener {
            val title = binding.edtTitle.text.toString()
            val message = binding.edtMessage.text.toString()

            if (title.isBlank()) {
                showBlankFieldsError()
                return@setOnClickListener
            }

            if (message.isBlank()) {
                showBlankFieldsError()
                return@setOnClickListener
            }

            viewModel.createNote(title, message)
        }
    }

    private fun readNoteFlow(note: NoteItemUI) {
        binding.toolbar.title = getString(R.string.edit_note)
        binding.edtTitle.setText(note.title)
        binding.edtMessage.setText(note.message)

        binding.fabDeleteNote.setOnClickListener {
            viewModel.deleteNote(note.id)
        }
    }

    private fun handleViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), getString(R.string.note_saved), Toast.LENGTH_LONG).show()
            dismiss()
        }

        viewModel.deleteViewState.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), getString(R.string.note_deleted), Toast.LENGTH_LONG).show()
            dismiss()
        }

        viewModel.errorState.observe(viewLifecycleOwner) {
            val errorText = "${getString(R.string.gen_error)}: ${it.message}"
            Toast.makeText(requireContext(), errorText, Toast.LENGTH_LONG).show()
        }
    }

    private fun showBlankFieldsError() {
        Toast.makeText(requireContext(), getString(R.string.error_blank_fields), Toast.LENGTH_LONG).show()
    }

    companion object {

        private const val TAG = "add_note_dialog"

        fun display(fragmentManager: FragmentManager, note: NoteItemUI? = null) {
            AddNoteDialogFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("note", note)
                }
            }.show(fragmentManager, TAG)
        }
    }
}