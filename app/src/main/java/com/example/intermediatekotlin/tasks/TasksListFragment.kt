package com.example.intermediatekotlin.tasks


import android.content.Context
import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.intermediatekotlin.R
import com.example.intermediatekotlin.models.Task
import com.example.intermediatekotlin.models.Todo
import kotlinx.android.synthetic.main.fragment_task.*

class TasksListFragment : Fragment() {

    lateinit var viewModel: TaskViewModel //initialize it later on, if initialized here view model will be tightly coupled with fragment lifecycle
    lateinit var touchAction: TouchAction
    private lateinit var contentView : TasksListView


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            //means if context is not null
            if (it is TouchAction)
                touchAction = it
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false).apply {
            contentView = this as TasksListView
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContentView()
        bindViewModel()

    }

    private fun setContentView() {
        contentView.initView(touchAction)
    }

    private fun bindViewModel() {
        viewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
        viewModel.taskListLiveData.observe(this, Observer { taskList ->
            //update the adapter
            contentView.updateList(taskList)
        })
    }

    companion object {

        //kotlin doesnt support static, so put the static codes inside companion object
        fun newInstance() = TasksListFragment()
    }

    interface TouchAction {
        fun onAddButtonClicked(value: String)
    }

}
