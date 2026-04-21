package com.openclassrooms.notes.data.service

// Importation du modèle représentant une note (titre + texte)
import com.openclassrooms.notes.data.model.Note

/**
 * NotesApiService
 *
 * Interface définissant les opérations disponibles pour gérer les notes.
 * Elle sert de contrat entre la couche de données (API locale, distante, fake, etc.)
 * et le Repository qui l'utilisera.
 *
 * Avantages :
 * - Permet de changer facilement d'implémentation (local, fake, réseau…)
 * - Facilite les tests unitaires
 * - Clarifie les responsabilités dans l'architecture MVVM
 */
interface NotesApiService {

    /**
     * Ajoute une nouvelle note à la source de données.
     *
     * @param note La note à ajouter (titre + texte)
     */
    fun addNote(note: Note)

    /**
     * Retourne la liste complète des notes disponibles.
     *
     * @return Une liste de Note
     */
    fun getAllNotes(): List<Note>
}
