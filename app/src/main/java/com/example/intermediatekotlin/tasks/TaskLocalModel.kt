package com.example.intermediatekotlin.tasks

import com.example.intermediatekotlin.models.Task
import com.example.intermediatekotlin.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor() : ITaskModel{
    override fun addTask(task: Task, callback: SuccessCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateTask(task: Task, callback: SuccessCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteTask(task: Task, callback: SuccessCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retriveTasks(): List<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFakeData(): MutableList<Task> = mutableListOf(
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