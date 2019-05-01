package com.example.intermediatekotlin.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intermediatekotlin.models.Task
import com.example.intermediatekotlin.models.Todo

class TaskViewModel : ViewModel(), TaskListViewContract {


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

    override fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean) {
        _taskListLiveData.value?.get(taskIndex)?.todos?.get(todoIndex)?.isComplete = isComplete

        //to get this triggered -> create a delegate in TasksListView which is the xml content of task fragment
    }
}