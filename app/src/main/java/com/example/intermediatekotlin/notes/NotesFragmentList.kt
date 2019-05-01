package com.example.intermediatekotlin.notes


import android.content.Context
import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.intermediatekotlin.R
import com.example.intermediatekotlin.models.Note
import com.example.intermediatekotlin.tasks.TasksListFragment
import kotlinx.android.synthetic.main.fragment_task.*

class NotesFragmentList : Fragment() {

    lateinit var viewModel: NoteViewModel
    lateinit var touchAction: NotesFragmentList.TouchAction
    lateinit var contentView : NotesListView

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            //means if context is not null
            if (it is NotesFragmentList.TouchAction)
                touchAction = it
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_fragment_list, container, false).apply {
            contentView = this as NotesListView
        }
    }

    private fun bindViewModel() {
        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        viewModel.notesLiveData.observe(this, Observer { notesList ->
            contentView.updateList(notesList)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        setContentView()
    }

    private fun setContentView() {
        contentView.initView(taDelegate = touchAction, daDelegate = viewModel)
    }

    companion object {
        fun newInstance() = NotesFragmentList()
    }

    interface TouchAction {
        fun onAddButtonClicked(value: String)
    }
}
