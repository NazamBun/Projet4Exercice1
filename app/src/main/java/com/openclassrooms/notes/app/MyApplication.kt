package com.openclassrooms.notes.app

import android.app.Application
import com.openclassrooms.notes.repository.NotesRepository

class MyApplication: Application() {
    val notesRepository: NotesRepository by lazy { NotesRepository() }
}