package com.example.intermediatekotlin.tasks

interface TaskListViewContract {
    //view model will implement this,
    // when a to-do is checked, view model will update itself and then
    // observer will handle these changes automatically
    fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean)
}