package com.example.intermediatekotlin.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intermediatekotlin.models.Note

class NoteViewModel :ViewModel(), NoteListViewContract {

    private val model : NoteModel = NoteModel()

    private val _notesListLiveData : MutableLiveData<MutableList<Note>> = MutableLiveData()

    val notesLiveData : LiveData<MutableList<Note>> = _notesListLiveData

    init {
        _notesListLiveData.postValue(model.getFakeData())
    }
}