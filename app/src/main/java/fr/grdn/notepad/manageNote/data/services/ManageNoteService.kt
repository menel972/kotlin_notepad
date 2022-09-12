package fr.grdn.notepad.manageNote.data.services

import android.content.Context
import fr.grdn.notepad.core.models.NoteModel
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class ManageNoteService {

    fun saveNote(context: Context, note: NoteModel) {
        val fileName = "${note.id}.note"
        val file = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        val stream = ObjectOutputStream(file)
        stream.writeObject(note)
        stream.close()
    }

    fun getNoteById(context: Context, fileName: String): NoteModel {
        val file = context.openFileInput(fileName)
        val stream = ObjectInputStream(file)
        val readingNote: NoteModel = stream.readObject() as NoteModel
        stream.close()

        return readingNote
    }

    fun getAllNotes(context: Context): MutableList<NoteModel> {
        val notes = mutableListOf<NoteModel>()
        val directory = context.filesDir

        for (fileName in directory.list()!!) {

            val note = getNoteById(context, fileName)
            notes.add(note)
        }
        return notes
    }

    fun deleteNote(context: Context, id: String) {
        val fileName = "$id.note"
        context.deleteFile(fileName)
    }
}
