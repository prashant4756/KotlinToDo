package com.example.intermediatekotlin.tasks

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intermediatekotlin.models.Task
import kotlinx.android.synthetic.main.fragment_task.view.*

//root layout of this tasksListfragment ,
//in onCreateView its infalted and casted to TasksListView,
//inside this TasksListView class recycler view is added

class TasksListView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {
    lateinit var adapter: TaskAdapter
    private lateinit var touchAction: TasksListFragment.TouchAction
    private lateinit var dataActionDelegate: TaskListViewContract

    fun initView(touchAction: TasksListFragment.TouchAction, daDelegate: TaskListViewContract) {
        setDelegate(touchAction, daDelegate)
        setUpView()
    }

    private fun setDelegate(touchAction: TasksListFragment.TouchAction, daDelegate: TaskListViewContract) {
        this.touchAction = touchAction
        this.dataActionDelegate = daDelegate
    }


    private fun setUpView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = TaskAdapter(
                touchAction = touchAction,
                dataActionDelegate = dataActionDelegate
        ) //named parameter
        recyclerView.adapter = adapter

    }

    fun updateList(tasks: List<Task>) {
        adapter.updateList(tasks)
    }
}