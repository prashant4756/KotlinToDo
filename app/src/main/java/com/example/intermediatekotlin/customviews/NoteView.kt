package com.example.intermediatekotlin.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.intermediatekotlin.models.Note
import kotlinx.android.synthetic.main.item_notes.view.*

class NoteView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView(note: Note) {
        titleView.text = note.description
    }
}