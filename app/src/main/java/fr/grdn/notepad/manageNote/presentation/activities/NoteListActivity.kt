package fr.grdn.notepad.manageNote.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import fr.grdn.notepad.R
import fr.grdn.notepad.databinding.NoteListLayoutBinding
import fr.grdn.notepad.manageNote.presentation.adapters.NoteListAdapter
import fr.grdn.notepad.manageNote.presentation.viewmodels.NoteListViewModel

class NoteListActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: NoteListLayoutBinding
    private lateinit var viewModel: NoteListViewModel
    private lateinit var adapter: NoteListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.note_list_layout)
        viewModel = NoteListViewModel(this)
        binding.viewModel = viewModel

        // RecyclerView
        adapter = NoteListAdapter(viewModel.notes, this)
        binding.noteListRecycler.layoutManager = LinearLayoutManager(this)
        binding.noteListRecycler.adapter = adapter

        // BottomBar
        binding.noteListBottomBar.setOnItemReselectedListener {
            navigateToCreateNote()
        }

        // Toolbar
        setSupportActionBar(binding.noteListToolbar)
    }

    override fun onClick(view: View) {
        val id: String = view.tag as String
        navigateToDetailsNote(id)
    }

    private val navigateAndGetResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        adapter.notifyDataSetChanged()
    }

    private fun navigateToCreateNote() {
        val intent = Intent(this, CreateNoteActivity::class.java)

        navigateAndGetResult.launch(intent)
    }

    private fun navigateToDetailsNote(id: String) {
        val intent = Intent(this, DetailsNoteActivity::class.java)
        intent.putExtra(DetailsNoteActivity.ID, id)

        navigateAndGetResult.launch(intent)
    }
}

