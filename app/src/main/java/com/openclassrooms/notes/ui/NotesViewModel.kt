package com.openclassrooms.notes.ui

import androidx.lifecycle.ViewModel
import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.data.repository.NotesRepository
import kotlinx.coroutines.flow.Flow

/**
 * ViewModel chargé d'exposer les données des notes à l'UI.
 * Il récupère les données depuis le Repository et les met à disposition
 * sous forme de Flow, sans contenir de logique d'affichage.
 */
class NotesViewModel : ViewModel() {

    // Source de données : le Repository gère l'accès aux notes.
    private val notesRepository = NotesRepository()

    /**
     * Flow exposé à l'UI.
     * Le ViewModel se contente de relayer le Flow fourni par le Repository.
     * L'intérêt : séparer la logique de données de la logique d'affichage.
     */
    val notes: Flow<List<Note>> = notesRepository.notes
}
