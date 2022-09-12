package fr.grdn.notepad.manageNote.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import fr.grdn.notepad.core.models.NoteModel
import fr.grdn.notepad.manageNote.domain.usecases.ManageNoteUseCase

class NoteListViewModel(context: Context) : ViewModel() {
    private val useCase: ManageNoteUseCase = ManageNoteUseCase()

    val notes: MutableList<NoteModel> = useCase.getAllNotes(context)

}