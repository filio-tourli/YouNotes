package com.filio.younotes.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.filio.younotes.R
import com.filio.younotes.data.NoteItemUI
import com.filio.younotes.databinding.ExampleDialogBinding


class AddNoteDialogFragment : DialogFragment() {

    private var _binding: ExampleDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog)
    }

    /** The system calls this to get the DialogFragment's layout, regardless
    of whether it's being displayed as a dialog or an embedded fragment. */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
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

        val note = arguments?.getParcelable<NoteItemUI>("note")

        if (note == null) {
            createNoteFlow()
        } else {
            readNoteFlow(note)
        }


    }

    private fun createNoteFlow() {
        binding.toolbar.title = getString(R.string.add_note)
    }

    private fun readNoteFlow(note: NoteItemUI) {
        binding.toolbar.title = note.title
        binding.txtMessage.text = note.message
    }

    companion object {

        private const val TAG = "add_note_dialog"

        fun display(fragmentManager: FragmentManager, note: NoteItemUI? = null) {
            val exampleDialog = AddNoteDialogFragment()
                .apply {
                    arguments = Bundle().apply {
                        putParcelable("note", note)
                    }
                }

            exampleDialog.show(fragmentManager, TAG)
        }
    }
}