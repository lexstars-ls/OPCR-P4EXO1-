package com.openclassrooms.notes.data.repository

import com.openclassrooms.notes.data.service.FakeApiNoteService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

// On active l'API expérimentale runTest (nécessaire pour tester les coroutines)
@OptIn(ExperimentalCoroutinesApi::class)
class NotesRepositoryTest {

    // FakeApiNoteService = source de vérité pour nos tests
    // On l'utilise pour connaître la liste "attendue"
    private val fakeService = FakeApiNoteService()

    // On vérifie que la première valeur émise par le Flow du Repository est identique à celle renvoyée par FakeApiNoteService.

    private val repository = NotesRepository()

    @Test
    fun `repository emits the same notes as FakeApiNoteService`() = runTest {
        // GIVEN : on récupère la liste que le service fake renvoie normalement
        // C'est notre valeur de référence (expected)
        val expectedNotes = fakeService.getAllNotes()

        // WHEN : on collecte la première valeur émise par le Flow du repository
        // Le Flow émet une seule fois, donc first() suffit
        val emittedNotes = repository.notes.first()

        // THEN : on vérifie que les deux listes sont identiques
        // Si c'est vrai, le Repository fonctionne correctement :
        // - il appelle bien FakeApiNoteService
        // - il émet bien la bonne liste via son Flow
        assertEquals(expectedNotes, emittedNotes)
    }
}
