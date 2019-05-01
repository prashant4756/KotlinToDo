package com.example.intermediatekotlin.notes

import com.example.intermediatekotlin.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor() : INoteModel{
    override fun addNote(note: Note, callback: SuccessCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateNote(note: Note, callback: SuccessCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNote(note: Note, callback: SuccessCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveNotes(): List<Note> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFakeData(): MutableList<Note> = mutableListOf(
            Note("This is my personal note"),
            Note("This is my public note"),
            Note("This is my ViewModel note")

    )
}