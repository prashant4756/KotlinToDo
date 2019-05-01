package com.example.intermediatekotlin.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.intermediatekotlin.R
import com.example.intermediatekotlin.customviews.TaskView
import com.example.intermediatekotlin.foundations.BaseAdapter
import com.example.intermediatekotlin.models.Task
import com.example.intermediatekotlin.navigation.NavigationActivity
import kotlinx.android.synthetic.main.view_add_button.view.*

class TaskAdapter(
        tasks: MutableList<Task> = mutableListOf(),
        val touchAction: TasksListFragment.TouchAction,
        val dataActionDelegate: TaskListViewContract
) : BaseAdapter<Task>(tasks) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if (viewType == TYPE_ADD_BUTTON) {
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
    } else {
        TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    }

    inner class TaskViewHolder(view: View) : BaseViewHolder<Task>(view) {
        override fun onBind(holderData: Task, listIndex: Int) {
            (view as TaskView).initView(holderData) { todoIndex, isChecked ->
                //since initview has 2nd parameter as a callback, so we need to implement that callback
                //thats why we have this lambda, here we are implementing that callback
                //which takes 2 params, which we are getting as todoIndex , isChecked ->
                dataActionDelegate.onTodoUpdated(listIndex, todoIndex, isChecked)
            }

        }
    }

    inner class AddButtonViewHolder(view: View) : BaseAdapter.AddButtonViewHolder(view) {
        override fun onBind(holderData: Unit, listIndex: Int) {
            view.buttonText.text = "Add New Task"
            view.setOnClickListener {
                touchAction.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_TASK)
            }
        }

    }
}