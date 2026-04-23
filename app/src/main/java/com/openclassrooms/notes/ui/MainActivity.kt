package com.openclassrooms.notes.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.openclassrooms.notes.R
import com.openclassrooms.notes.databinding.ActivityMainBinding
import com.openclassrooms.notes.ui.widget.NoteItemDecoration
import com.openclassrooms.notes.ui.widget.NotesAdapter
import com.openclassrooms.notes.ui.NotesViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Adapter chargé d'afficher la liste des notes dans le RecyclerView.
    private val notesAdapter = NotesAdapter(emptyList())

    // ViewModel associé à l'activité (créé automatiquement via delegation).
    private val viewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initFABButton()
        observeNotes()
    }

    /**
     * Observe le Flow exposé par le ViewModel.
     * À chaque nouvelle liste émise, l'adapter est mis à jour.
     * L'observation est lancée dans lifecycleScope pour respecter le cycle de vie.
     */
    private fun observeNotes() {
        lifecycleScope.launch {
            viewModel.notes.collect { notes ->
                notesAdapter.updateNotes(notes)
            }
        }
    }

    /**
     * Initialise le bouton d'ajout.
     * Pour l'instant, affiche simplement un message "à venir".
     */
    private fun initFABButton() {
        binding.btnAdd.setOnClickListener {
            MaterialAlertDialogBuilder(this).apply {
                setTitle(R.string.coming_soon)
                setMessage(R.string.not_available_yet)
                setPositiveButton(android.R.string.ok, null)
            }.show()
        }
    }

    /**
     * Configure le RecyclerView :
     * - ajoute une décoration pour gérer les marges
     * - associe l'adapter chargé d'afficher les notes
     */
    private fun initRecyclerView() {
        with(binding.recycler) {
            addItemDecoration(
                NoteItemDecoration(
                    resources.getDimensionPixelSize(R.dimen.default_margin),
                    resources.getInteger(R.integer.span_count)
                )
            )
            adapter = notesAdapter
        }
    }
}
