package com.example.intermediatekotlin.notes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intermediatekotlin.models.Note
import kotlinx.android.synthetic.main.fragment_notes_fragment_list.view.*

class NotesListView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var adapter: NotesAdapter
    private lateinit var touchAction: NotesFragmentList.TouchAction
    private lateinit var dataActionDelegate : NoteListViewContract

    fun initView(taDelegate : NotesFragmentList.TouchAction, daDelegate : NoteListViewContract){
        setDelegate(taDelegate, daDelegate)
        setUpView()
    }

    private fun setUpView(){
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = NotesAdapter(touchAction =  touchAction)
        recyclerView.adapter = adapter

    }

    private fun setDelegate(taDelegate: NotesFragmentList.TouchAction, daDelegate: NoteListViewContract) {
        touchAction = taDelegate
        dataActionDelegate = daDelegate
    }

    fun updateList(notes : List<Note>){
        adapter.updateList(notes)
    }
}