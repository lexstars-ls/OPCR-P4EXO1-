package com.openclassrooms.notes.ui.widget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.notes.databinding.NoteBinding
import com.openclassrooms.notes.data.model.Note

/**
 * Adapter chargé d'afficher une liste de notes dans le RecyclerView.
 * Il crée les ViewHolder et leur fournit les données à afficher.
 */
class NotesAdapter(private var notes: List<Note>) : RecyclerView.Adapter<NoteViewHolder>() {

    /**
     * Met à jour la liste affichée.
     * Remplace l'ancienne liste par la nouvelle puis rafraîchit l'affichage.
     * (Approche simple : notifyDataSetChanged, sans diffing pour l'instant.)
     */
    fun updateNotes(newNotes: List<Note>) {
        notes = newNotes
        notifyDataSetChanged()
    }

    /**
     * Crée un ViewHolder en gonflant le layout associé à une note.
     * Appelé automatiquement par le RecyclerView lorsque nécessaire.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    /**
     * Retourne le nombre d'éléments à afficher.
     */
    override fun getItemCount(): Int = notes.size

    /**
     * Associe la note correspondant à la position donnée au ViewHolder.
     * Le ViewHolder se charge ensuite de remplir les vues.
     */
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }
}
