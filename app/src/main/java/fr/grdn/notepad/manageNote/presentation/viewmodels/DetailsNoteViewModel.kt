package fr.grdn.notepad.manageNote.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import fr.grdn.notepad.core.models.NoteModel
import fr.grdn.notepad.manageNote.domain.usecases.ManageNoteUseCase

class DetailsNoteViewModel(val context: Context, private val noteId: String) : ViewModel() {
    private val useCase: ManageNoteUseCase = ManageNoteUseCase()

    fun getSelectedNote(): NoteModel {
        return useCase.getNoteById(context, noteId)
    }
}