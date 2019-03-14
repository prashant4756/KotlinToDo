package com.example.intermediatekotlin.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intermediatekotlin.models.Task
import com.example.intermediatekotlin.models.Todo

class TaskViewModel : ViewModel() {

    private val _taskListLiveData : MutableLiveData<MutableList<Task>> = MutableLiveData() //it can be changed manually
    val taskListLiveData : LiveData<MutableList<Task>> = _taskListLiveData //LiveData cannot be changed manually, it will be same always (Read only access)

    init {
        //called whenever a constructor is made
//        _taskListLiveData.value = getFakeData() //synchronously
        _taskListLiveData.postValue(getFakeData())  //asynchronously (large data)
    }

    fun getFakeData() : MutableList<Task> = mutableListOf(
            Task("Buy groceries", mutableListOf(
                    Todo("Todo 1", true),
                    Todo("Todo 2")
            )),
            Task("Buy more groceries"),
            Task("Testing through viewmodel", mutableListOf(
                    Todo("test A"),
                    Todo("test B")
            ))
    )
}