package com.filio.younotes.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filio.younotes.db.NoteItemDB
import com.filio.younotes.db.NotesDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val dao: NotesDao) : ViewModel() {

    val viewState = MutableLiveData<Unit>()
    val deleteViewState = MutableLiveData<Unit>()
    val errorState = MutableLiveData<Exception>()

    fun createNote(title: String, message: String) {
        viewModelScope.launch {
            try {
                val note = NoteItemDB(
                    title = title,
                    message = message,
                    createdAt = ZonedDateTime.now(),
                    editedAt = ZonedDateTime.now()
                )

                dao.insert(note)

                viewState.postValue(Unit)
            } catch (e: Exception) {
                e.printStackTrace()
                errorState.postValue(e)
            }
        }
    }

    fun deleteNote(noteId: Int) {
        viewModelScope.launch {
            try {
                dao.deleteById(noteId)

                deleteViewState.postValue(Unit)
            } catch (e: Exception) {
                e.printStackTrace()
                errorState.postValue(e)
            }
        }
    }

}