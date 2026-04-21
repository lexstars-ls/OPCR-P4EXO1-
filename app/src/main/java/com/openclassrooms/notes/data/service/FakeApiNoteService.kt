package com.openclassrooms.notes.data.service

import com.openclassrooms.notes.data.model.Note

/**
 * Implémentation locale de l'API de notes.
 *
 * Cette classe simule une source de données locale (en mémoire).
 * Elle est utile pour :
 * - tester l'application sans backend
 * - fournir des données statiques ou temporaires
 * - séparer clairement l'interface (NotesApiService) de son implémentation
 *
 * Dans une vraie application, cette classe pourrait être remplacée par :
 * - une API REST
 * - une base de données Room
 * - un stockage local (fichier, DataStore…)
 */
class FakeApiNoteService : NotesApiService {

    /**
     * Ajoute une note à la source de données.
     *
     * Pour l'instant, non implémenté.
     * - stocker les notes dans une liste mutable
     * - ou persister dans une base locale
     */
    override fun addNote(note: Note) {
        TODO("Not yet implemented")
    }

    /**
     * Retourne une liste de notes pré-remplies.
     *
     * Cette liste sert de données factices (fake data) pour tester l'affichage.
     * Elle imite ce qu'une vraie API renverrait.
     */
    override fun getAllNotes(): List<Note> {
        return listOf(
            Note("La vie est belle", "La vie est belle, pleine de choses à voir et à faire. Profitez de chaque moment et ne laissez jamais personne vous dire que vous ne pouvez pas faire ce que vous voulez."),
            Note("Ne laissez personne vous dire que vous ne pouvez pas faire quelque chose.", "Croyez en vous et en vos capacités. Ne laissez personne vous dire que vous ne pouvez pas faire quelque chose. Suivez vos rêves et ne laissez rien vous arrêter."),
            Note("Suivez vos rêves", "Ne laissez rien vous arrêter de suivre vos rêves. Travaillez dur et ne vous découragez jamais. Vos rêves sont à votre portée, alors n'ayez pas peur de les poursuivre."),
            Note("Soyez gentil avec les autres", "Le monde a besoin de plus de gentillesse. Soyez gentil avec les autres, même si ce n'est pas facile. La gentillesse peut faire une grande différence dans le monde."),
            Note("Aidez les autres", "Le monde est un meilleur endroit lorsque nous travaillons ensemble. Aidez les autres, même si c'est juste un petit geste. Chaque geste compte."),
            Note("Soyez reconnaissant pour ce que vous avez.", "Il y a toujours quelqu'un qui a moins que vous. Soyez reconnaissant pour ce que vous avez, même si ce n'est pas grand-chose. La gratitude peut vous rendre heureux et épanoui."),
            Note("Vivez le moment présent", "Ne vous inquiétez pas du passé et ne vous inquiétez pas de l'avenir. Vivez le moment présent et profitez de chaque minute. Le moment présent est tout ce que vous avez"),
            Note("Prenez soin de vous", "Mangez sainement, faites de l'exercice et dormez suffisamment. Prenez soin de votre corps et de votre esprit. Vous êtes votre meilleur atout."),
            Note("Passez du temps avec vos proches", "Ils sont les plus importants dans votre vie. Passez du temps avec vos proches et montrez-leur à quel point vous les aimez. Ils sont votre famille et vos amis."),
            Note("Risez et amusez-vous.", "La vie est trop courte pour être sérieuse tout le temps. Riez et amusez-vous. Passez du temps à faire les choses que vous aimez."),
        )
    }
}
