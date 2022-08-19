package com.filio.younotes

import android.content.Context
import com.filio.younotes.data.NoteItemUI
import java.time.ZonedDateTime

object MockData {

    fun getNotes() = listOf(
        NoteItemUI(
            id = 0,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        ),
        NoteItemUI(
            id = 1,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        ),
        NoteItemUI(
            id = 2,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        ),
        NoteItemUI(
            id = 3,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        ),
        NoteItemUI(
            id = 4,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        ),
        NoteItemUI(
            id = 5,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        ),
        NoteItemUI(
            id = 6,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        ),
        NoteItemUI(
            id = 7,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        ),
        NoteItemUI(
            id = 8,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        ),
        NoteItemUI(
            id = 9,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        ),
        NoteItemUI(
            id = 10,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        ),
        NoteItemUI(
            id = 11,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        )
    )

    fun getNotes(count: Int, context: Context): List<NoteItemUI> {
        val tempList = mutableListOf<NoteItemUI>()

        for (index in 0 until count) {
            val random = (50..500).random()
            val sampleText = context.getString(R.string.lorem).take(random)
            val note = NoteItemUI(
                id = 11,
                title = "My note ${index + 1}",
                message = sampleText,
                createdAt = ZonedDateTime.now(),
                editedAt = ZonedDateTime.now()
            )
            tempList.add(note)
        }

        return tempList.toList()
    }
}