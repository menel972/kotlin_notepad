package fr.grdn.notepad.manageNote.domain.repositories

import android.content.Context
import fr.grdn.notepad.core.models.NoteModel

interface ManageNoteRepository {
    fun saveNote(context: Context, note: NoteModel)
    fun getNoteById(context: Context, id: String): NoteModel
    fun getAllNotes(context: Context): MutableList<NoteModel>
    fun deleteNote(context: Context, id: String)
}