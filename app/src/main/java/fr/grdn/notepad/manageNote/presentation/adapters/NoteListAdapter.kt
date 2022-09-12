package fr.grdn.notepad.manageNote.presentation.adapters

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import fr.grdn.notepad.R
import fr.grdn.notepad.R.id
import fr.grdn.notepad.core.models.NoteModel

class NoteListAdapter(
    private val notes: MutableList<NoteModel>,
    private val listener: View.OnClickListener
) : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(id.noteListCard)
        val title: TextView = itemView.findViewById(id.noteListTitle)
        val date: TextView = itemView.findViewById(id.noteListDate)
        val text: TextView = itemView.findViewById(id.noteListText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_list_card, parent, false)

        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]

        holder.cardView.setOnClickListener(listener)
        holder.cardView.tag = note.id
        holder.title.text = note.title
        holder.date.text = DateFormat.format("dd/MM/yyyy", note.date)
        holder.text.text = note.texte
    }

    override fun getItemCount(): Int {
        return notes.size
    }

}