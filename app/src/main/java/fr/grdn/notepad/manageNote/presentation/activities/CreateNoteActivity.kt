package fr.grdn.notepad.manageNote.presentation.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import fr.grdn.notepad.R
import fr.grdn.notepad.core.models.NoteModel
import fr.grdn.notepad.databinding.CreateNoteLayoutBinding
import fr.grdn.notepad.manageNote.domain.usecases.ManageNoteUseCase
import java.util.*

class CreateNoteActivity : AppCompatActivity() {
    private lateinit var binding: CreateNoteLayoutBinding
    private lateinit var useCase: ManageNoteUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.create_note_layout)

        // UseCase
        useCase = ManageNoteUseCase()

        // Toolbar
        setSupportActionBar(binding.createNoteToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.createNoteToolbar.setNavigationOnClickListener {
            saveNewNote()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.new_note_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        saveNewNote()
        return true
    }

    private fun saveNewNote() {
        val newNote = NoteModel(
            id = UUID.randomUUID().toString(),
            title = binding.createNoteTitle.text.toString(),
            texte = binding.createNoteText.text.toString(),
            date = Date()
        )

        useCase.saveNote(this, newNote)
        finish()
    }
}