package com.example.intermediatekotlin.customviews

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import com.example.intermediatekotlin.models.Todo

import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.todo_view.view.*

class TodoView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {


    fun initView(todo: Todo, callback: ((Boolean) -> Unit)?=null) {

        descriptionView.text = todo.description
        isCompleteCheckBox.isChecked = todo.isComplete

        if (todo.isComplete) {
            descriptionView.paintFlags = descriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        setCheckChangedListener(todo, callback)
    }

    // on check change we need to send somehow to taskview that a checkbox is changed,
    //  so that we can run isTaskComplete(all todos are completed) function in taskview

    //passing function variable in this function

    // The type with only one value: the `Unit` object.
    // This type corresponds to the `void` type in Java.

    //passing in a function into our function
    //the function which we are passing has -> 1 boolean parameter and returning null
    // if you see -> Unit that is a void function in java
    // ? for this function can be null,
    // and by default we are passing null (this function is null by default)
    // operate this function : callback.invoke()

    //dont know what this function does, but everytime when checkbox is checked, we invoke this function
    fun setCheckChangedListener(todo : Todo, callback : ((Boolean) -> Unit)?=null) {
        isCompleteCheckBox.setOnCheckedChangeListener { _, isChecked ->
//            todo.isComplete = isChecked
            callback?.invoke(isChecked) //means if callback is null, it will not execute invoke(ischecked)
            if (isChecked) {
                createStrikeThrough()
            } else
                removeStrikeThrough()
        }
    }

    private fun createStrikeThrough() {
        descriptionView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

    }

    private fun removeStrikeThrough() {
        descriptionView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }


}
