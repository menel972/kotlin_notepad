package fr.grdn.notepad.manageNote.domain.usecases

import android.content.Context
import fr.grdn.notepad.core.models.NoteModel
import fr.grdn.notepad.manageNote.data.repositories.ManageNoteRepositoryImpl
import fr.grdn.notepad.manageNote.domain.repositories.ManageNoteRepository

class ManageNoteUseCase {
    private val repository: ManageNoteRepository = ManageNoteRepositoryImpl()

    fun saveNote(context: Context, note: NoteModel) {
        repository.saveNote(context, note)
    }

    fun getNoteById(context: Context, id: String): NoteModel {
        return repository.getNoteById(context, id)
    }

    fun getAllNotes(context: Context): MutableList<NoteModel> {
        return repository.getAllNotes(context)
    }

    fun deleteNote(context: Context, id: String) {
        repository.deleteNote(context, id)
    }
}