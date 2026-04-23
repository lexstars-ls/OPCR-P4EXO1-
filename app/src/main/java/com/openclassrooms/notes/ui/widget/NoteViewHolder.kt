package com.openclassrooms.notes.ui.widget

import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.databinding.NoteBinding

/**
 * ViewHolder chargé d'afficher une note dans le RecyclerView.
 * Il associe un objet Note aux vues du layout via le binding.
 */
class NoteViewHolder(private val binding: NoteBinding) : RecyclerView.ViewHolder(binding.root) {

    /**
     * Injecte les données de la note dans les vues du layout.
     * Le ViewHolder ne fait que remplir l'UI avec les valeurs du modèle.
     */
    fun bind(note: Note) {
        binding.title.text = note.title
        binding.body.text = note.body
    }
}
