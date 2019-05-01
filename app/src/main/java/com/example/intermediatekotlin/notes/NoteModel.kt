package com.example.intermediatekotlin.notes

import com.example.intermediatekotlin.models.Note

class NoteModel {

    fun getFakeData(): MutableList<Note> = mutableListOf(
            Note("This is my personal note"),
            Note("This is my public note"),
            Note("This is my ViewModel note")

    )
}