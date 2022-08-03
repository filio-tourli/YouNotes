package com.filio.younotes

import com.filio.younotes.data.NoteItemUI
import java.time.ZonedDateTime

object MockData {

    fun getNoted() = listOf(
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
        ), NoteItemUI(
            id = 6,
            title = "This is a test not",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            createdAt = ZonedDateTime.now(),
            editedAt = ZonedDateTime.now()
        )
    )
}