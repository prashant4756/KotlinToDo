package com.example.intermediatekotlin.models

/*
* Title | String | N
todos | List<Todo> | Y
tag | Tag | Y
* */

//@JvmOverloads constructor : this is needed only while accessing from java file, if you dont provide arguments that has already set to default
data class Task @JvmOverloads constructor(
        var title : String,
//        val todos : MutableList<Todo>?, // it can be null if not provided any value
        val todos : MutableList<Todo> = mutableListOf(),
        var tag : Tag? = null //this assignment is default value, if we dont pass anything for tag it wil be automatically null
) {

}


data class Todo(
        var description :String,
        var isComplete : Boolean = false
){

}

data class Tag(
      val name : String,
      val colorResID : Int
){

}


data class Note @JvmOverloads constructor(
    var description: String,
    var tag : Tag? = null
){

}