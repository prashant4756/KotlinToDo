package com.example.intermediatekotlin.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.intermediatekotlin.R
import com.example.intermediatekotlin.customviews.NoteView
import com.example.intermediatekotlin.foundations.BaseAdapter
import com.example.intermediatekotlin.models.Note
import com.example.intermediatekotlin.navigation.NavigationActivity
import kotlinx.android.synthetic.main.view_add_button.view.*

class NotesAdapter(
        notes: MutableList<Note> = mutableListOf(),
        val touchAction: NotesFragmentList.TouchAction
) : BaseAdapter<Note>(notes) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if (viewType == TYPE_ADD_BUTTON) {
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
    } else {
        NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false))
    }

    class NoteViewHolder(view: View) : BaseViewHolder<Note>(view) {
        override fun onBind(holderData: Note,  listIndex : Int) {
//            (view as NoteView).apply { initView(holderData) }
            (view as NoteView).initView(holderData)
        }
    }


    inner class AddButtonViewHolder(view: View) : BaseAdapter.AddButtonViewHolder(view) {
        override fun onBind(holderData: Unit,  listIndex : Int) {
            view.buttonText.text = "Add New Note"
            view.setOnClickListener {
                touchAction.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_NOTE)
            }
        }

    }

}