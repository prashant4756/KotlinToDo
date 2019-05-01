package com.example.intermediatekotlin.foundations

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(
        protected val masterList: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_ADD_BUTTON = 0
        const val TYPE_INFO = 1
    }

    fun  updateList(data: List<T>) {

        val result = DiffUtil.calculateDiff(DiffUtilCallbackImp(masterList, data))
        masterList.clear()
        masterList.addAll(data)
        result.dispatchUpdatesTo(this)
    }

    override fun getItemViewType(position: Int): Int = if (position == 0) {
        TYPE_ADD_BUTTON
    } else {
        TYPE_INFO
    }

    override fun getItemCount() = masterList.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AddButtonViewHolder)
            (holder).onBind(Unit, position - 1)
        else
            (holder as BaseViewHolder<T>).onBind(masterList[position - 1], position - 1)
    }

    abstract class BaseViewHolder<E>(val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun onBind(holderData: E, listIndex: Int) //need to implement this in class which extends baseadapter
    }

    abstract class AddButtonViewHolder(view: View) : BaseViewHolder<Unit>(view)

    class DiffUtilCallbackImp <T>(val oldList : List<T>, val newList : List<T>) : DiffUtil.Callback( ){
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean  =
                oldList[oldItemPosition] == newList[newItemPosition]

        override fun getOldListSize(): Int  = oldList.size

        override fun getNewListSize(): Int  = newList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                oldList[oldItemPosition] == newList[newItemPosition]

    }
}