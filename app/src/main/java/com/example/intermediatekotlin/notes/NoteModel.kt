package com.example.intermediatekotlin.notes

import com.example.intermediatekotlin.models.Note
import javax.inject.Inject

class NoteModel @Inject constructor(){

    fun getFakeData(): MutableList<Note> = mutableListOf(
            Note("This is my personal note"),
            Note("This is my public note"),
            Note("This is my ViewModel note")

    )
}