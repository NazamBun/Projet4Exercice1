package com.openclassrooms.notes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.openclassrooms.notes.app.MyApplication
import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import kotlinx.coroutines.flow.Flow

class NotesViewModel(private val notesRepository: NotesRepository): ViewModel() {
    val notes: Flow<List<Note>> = notesRepository.notes

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()

                return NotesViewModel(
                    (application as MyApplication).notesRepository,
                    //savedStateHandle
                ) as T
            }
        }
    }
}