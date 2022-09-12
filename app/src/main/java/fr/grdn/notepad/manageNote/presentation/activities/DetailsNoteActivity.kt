package fr.grdn.notepad.manageNote.presentation.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import fr.grdn.notepad.R
import fr.grdn.notepad.core.models.NoteModel
import fr.grdn.notepad.databinding.DetailsNoteLayoutBinding
import fr.grdn.notepad.manageNote.domain.usecases.ManageNoteUseCase
import fr.grdn.notepad.manageNote.presentation.viewmodels.DetailsNoteViewModel
import java.util.*

class DetailsNoteActivity : AppCompatActivity() {
    private lateinit var binding: DetailsNoteLayoutBinding
    private lateinit var viewModel: DetailsNoteViewModel
    private lateinit var useCase: ManageNoteUseCase
    lateinit var id: String

    companion object {
        const val ID: String = "noteId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.details_note_layout)
        viewModel = DetailsNoteViewModel(this, id)
        binding.viewModel = viewModel
        id = intent.getStringExtra(ID)!!

        // UseCase
        useCase = ManageNoteUseCase()

        // Toolbar
        setSupportActionBar(binding.detailsNoteToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.detailsNoteToolbar.setNavigationOnClickListener() {
            updateNote()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.details_notes_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete -> deleteNote()
            else -> updateNote()
        }
        return true
    }

    private fun updateNote() {
        val updatedNote = NoteModel(
            id = id,
            title = binding.detailsNoteTitle.text.toString(),
            texte = binding.detailsNoteText.text.toString(),
            date = Date()
        )

        useCase.saveNote(this, updatedNote)
        finish()
    }


    private fun deleteNote() {
        useCase.deleteNote(this, id)
        finish()
    }
}