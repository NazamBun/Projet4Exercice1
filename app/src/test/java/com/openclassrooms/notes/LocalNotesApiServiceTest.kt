package com.openclassrooms.notes

import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.service.LocalNotesApiService
import com.openclassrooms.notes.service.NotesApiService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LocalNotesApiServiceTest {
    private lateinit var notesApiService: NotesApiService
    @Before
    fun setUp() {
        notesApiService = LocalNotesApiService()
    }

    @Test
    fun testGetAllNotes() {
        val notes = notesApiService.getAllNotes()
        assert(notes.isNotEmpty())
        assertEquals(10, notes.size)
    }

    /**
     * Test the addNote method
     */

    @Test
    fun testAddNote() {
        val notes = notesApiService.getAllNotes()
        val initialSize = notes.size
        notesApiService.addNote(
            Note(
                title = "Title",
                body = "Body"
            )
        )
        assertEquals(initialSize + 1, notesApiService.getAllNotes().size)
    }

    /**
     * Test the collectNotes method
     */

    @Test
    fun collectNotes() {
        val newNote = Note(
            title = "Title",
            body = "Body"
        )
        notesApiService.addNote(newNote)
        val notes = notesApiService.getAllNotes()
        assert(notes.isNotEmpty())
        assertEquals(11, notes.size)
        assertEquals(newNote, notes.last())
        assertEquals("Title", notes[10].title)
    }
}