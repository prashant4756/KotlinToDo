package com.example.intermediatekotlin.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intermediatekotlin.models.Note

class NoteViewModel :ViewModel() {

    private val _notesListLiveData : MutableLiveData<MutableList<Note>> = MutableLiveData()
    val notesLiveData : LiveData<MutableList<Note>> = _notesListLiveData

    init {
        _notesListLiveData.postValue(getFakeData())
    }

    fun getFakeData() : MutableList<Note> = mutableListOf(
            Note("This is my personal note"),
            Note("This is my public note"),
            Note("This is my ViewModel note")

    )
}