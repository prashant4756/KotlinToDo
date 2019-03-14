package com.example.intermediatekotlin.tasks

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intermediatekotlin.models.Task
import kotlinx.android.synthetic.main.fragment_task.*
import kotlinx.android.synthetic.main.fragment_task.view.*

class TasksListView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {
    lateinit var adapter: TaskAdapter
    private lateinit var touchAction: TasksListFragment.TouchAction

    fun initView(touchAction: TasksListFragment.TouchAction){
        setDelegate(touchAction)
        setUpView()
    }

    private fun setDelegate(touchAction: TasksListFragment.TouchAction){
        this.touchAction = touchAction
    }


    private fun setUpView(){
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = TaskAdapter(touchAction = touchAction) //named parameter
        recyclerView.adapter = adapter

    }

    fun updateList(tasks : List<Task>){
        adapter.updateList(tasks)
    }
}