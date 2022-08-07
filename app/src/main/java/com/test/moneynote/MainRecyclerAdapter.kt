package com.test.moneynote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.moneynote.database.ListItem
import com.test.moneynote.databinding.ItemMainListBinding

class MainRecyclerAdapter(val clickListener: MainRecyclerListener)
    : ListAdapter<ListItem, MainRecyclerAdapter.ViewHolder>(MainRecyclerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item, clickListener)
    }

    class ViewHolder private constructor(val binding: ItemMainListBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: ListItem, clickListener: MainRecyclerListener) {
//            binding.quiz = item
//            binding.clickListener = clickListener
//            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMainListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class MainRecyclerDiffCallback : DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.listItemId == newItem.listItemId
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem == newItem
    }
}

class MainRecyclerListener(val clickListener: (listItemId: Long) -> Unit) {
    fun onClick(item: ListItem){
        clickListener(item.listItemId)
    }
}

