package fr.grdn.notepad.manageNote.data.repositories

import android.content.Context
import fr.grdn.notepad.core.models.NoteModel
import fr.grdn.notepad.manageNote.data.services.ManageNoteService
import fr.grdn.notepad.manageNote.domain.repositories.ManageNoteRepository

class ManageNoteRepositoryImpl() : ManageNoteRepository {
    private val service: ManageNoteService = ManageNoteService()

    override fun saveNote(context: Context, note: NoteModel) {
        service.saveNote(context, note)
    }

    override fun getNoteById(context: Context, id: String): NoteModel {
        val fileName: String = "$id.note"
        return service.getNoteById(context, fileName)
    }

    override fun getAllNotes(context: Context): MutableList<NoteModel> {
        return service.getAllNotes(context)
    }

    override fun deleteNote(context: Context, id: String) {
        service.deleteNote(context, id)
    }

}