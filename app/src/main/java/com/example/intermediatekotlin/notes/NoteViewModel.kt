package com.example.intermediatekotlin.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intermediatekotlin.foundations.ApplicationScope
import com.example.intermediatekotlin.models.Note
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class NoteViewModel : ViewModel(), NoteListViewContract {

    @Inject
    lateinit var model: INoteModel

    private val _notesListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()

    val notesLiveData: LiveData<MutableList<Note>> = _notesListLiveData

    init {
        Toothpick.inject(this, ApplicationScope.scope)
        _notesListLiveData.postValue(model.getFakeData())
    }
}