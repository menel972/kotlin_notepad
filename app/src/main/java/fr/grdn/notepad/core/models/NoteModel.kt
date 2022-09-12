package fr.grdn.notepad.core.models

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable
import java.util.*

data class NoteModel constructor(
    var id: String,
    var title: String?,
    var texte: String?,
    var date: Date
) : Parcelable, Serializable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString(),
        Date(parcel.readLong())
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(texte)
        parcel.writeLong(date.time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NoteModel> {
        override fun createFromParcel(parcel: Parcel): NoteModel {
            return NoteModel(parcel)
        }

        override fun newArray(size: Int): Array<NoteModel?> {
            return arrayOfNulls(size)
        }
    }
}
