package com.example.intermediatekotlin.foundations

import com.example.intermediatekotlin.notes.INoteModel
import com.example.intermediatekotlin.notes.NoteLocalModel
import com.example.intermediatekotlin.tasks.ITaskModel
import com.example.intermediatekotlin.tasks.TaskLocalModel
import toothpick.Toothpick
import toothpick.config.Module

object ApplicationScope{
    //objects are singleton in kotlin/ so contructor invocation not required

    val scope = Toothpick.openScope(this).apply {
        installModules(ApplicationModule)
    }
}

object ApplicationModule : Module(){
    init {
        bind(INoteModel::class.java).toInstance(NoteLocalModel())
        bind(ITaskModel::class.java).toInstance(TaskLocalModel())
    }
}