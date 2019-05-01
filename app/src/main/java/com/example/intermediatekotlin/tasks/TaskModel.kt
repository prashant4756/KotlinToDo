package com.example.intermediatekotlin.tasks

import com.example.intermediatekotlin.models.Task
import com.example.intermediatekotlin.models.Todo

class TaskModel {
    fun getFakeData(): MutableList<Task> = mutableListOf(
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