package com.openclassrooms.notes.data.repository

import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.data.service.FakeApiNoteService
import com.openclassrooms.notes.data.service.NotesApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Repository responsable de fournir les données des notes.
 * Il encapsule l'accès à la source de données.
 */
class NotesRepository {

    /**
     * Service jouant le rôle de source de données.
     * Ici, FakeApiNoteService renvoie une liste statique de notes.
     */
    private val notesApiService: NotesApiService = FakeApiNoteService()

    /**
     * Flow qui émet le résultat de getAllNotes().
     * À chaque collecte, le Flow appelle getAllNotes() sur le service
     * puis renvoie la liste obtenue de manière asynchrone.
     */
    val notes: Flow<List<Note>> = flow {
        emit(notesApiService.getAllNotes())
    }
}
