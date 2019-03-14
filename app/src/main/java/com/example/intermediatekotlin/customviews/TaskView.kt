package com.example.intermediatekotlin.customviews

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.intermediatekotlin.R
import com.example.intermediatekotlin.models.Task
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.view_add_button.view.*

/*{ isChecked ->
                             //this curly bracket is a function passed as parameter to initview
                            if(isChecked )
                                createStrikeThrough()
                             else
                                removeStrikeThrough()
                         }*/
//above is an anonymous function, which seem like a parameter to function
//this anonymous function will be executed when we will do callback.invoke(boolean)

class TaskView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var task: Task

     fun initView(task : Task){

         this.task = task;

         titleView.text = task.title
         task.todos.forEach{ todo ->

             var todoView = (LayoutInflater.from(this.context).inflate(R.layout.todo_view, todoContainer, false) as TodoView)
                     .apply {
                         initView(todo) {
                             //this curly bracket is a function passed as parameter to initview
                             if(isTaskComplete() )
                                 createStrikeThrough()
                             else
                                 removeStrikeThrough()
                         }
                     }
             this.todoContainer.addView(todoView)
         }
     }

    fun isTaskComplete() : Boolean =  task.todos.filter { task -> !task.isComplete }.isEmpty()

    private fun createStrikeThrough() {
        titleView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

    }

    private fun removeStrikeThrough() {
        titleView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}