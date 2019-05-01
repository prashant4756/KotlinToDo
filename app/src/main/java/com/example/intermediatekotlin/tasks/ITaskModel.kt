package com.example.intermediatekotlin.tasks

import com.example.intermediatekotlin.models.Task

typealias SuccessCallBack = (Boolean) -> Unit

interface ITaskModel {
    fun addTask(task : Task, callback : SuccessCallBack)
    fun updateTask(task : Task, callback : SuccessCallBack)
    fun deleteTask(task : Task, callback : SuccessCallBack)
    fun retriveTasks() : List<Task >
    fun getFakeData() : MutableList<Task>
}