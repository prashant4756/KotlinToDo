package com.example.intermediatekotlin.notes

import com.example.intermediatekotlin.models.Note

typealias SuccessCallBack = (Boolean) -> Unit

interface INoteModel {
    fun addNote(note: Note, callback : SuccessCallBack)

    fun updateNote(note: Note, callback : SuccessCallBack)

    fun deleteNote(note: Note, callback : SuccessCallBack)

    fun retrieveNotes(): List<Note>

    fun getFakeData() : MutableList<Note>
}