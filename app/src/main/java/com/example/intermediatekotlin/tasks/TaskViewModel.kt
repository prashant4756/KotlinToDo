package com.example.intermediatekotlin.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intermediatekotlin.foundations.ApplicationScope
import com.example.intermediatekotlin.models.Task
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class TaskViewModel : ViewModel(), TaskListViewContract {

    @Inject
    lateinit var model: ITaskModel

    private val _taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData() //it can be changed manually
    val taskListLiveData: LiveData<MutableList<Task>> = _taskListLiveData //LiveData cannot be changed manually, it will be same always (Read only access)

    init {

        //toothpick is scope based di
        Toothpick.inject(this, ApplicationScope.scope)

        //called whenever a constructor is made
//        _taskListLiveData.value = getFakeData() //synchronously
        _taskListLiveData.postValue(model.getFakeData())  //asynchronously (large data)
    }

    override fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean) {
        _taskListLiveData.value?.get(taskIndex)?.todos?.get(todoIndex)?.isComplete = isComplete

        //to get this triggered -> create a delegate in TasksListView which is the xml content of task fragment
    }
}