package com.example.intermediatekotlin.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intermediatekotlin.models.Note
import toothpick.Toothpick
import javax.inject.Inject

class NoteViewModel : ViewModel(), NoteListViewContract {

    @Inject
    lateinit var model: NoteModel

    private val _notesListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()

    val notesLiveData: LiveData<MutableList<Note>> = _notesListLiveData

    init {
        val scope = Toothpick.openScope(this)
        Toothpick.inject(this, scope)
        _notesListLiveData.postValue(model.getFakeData())
    }
}