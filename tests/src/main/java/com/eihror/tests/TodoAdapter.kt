package com.eihror.tests

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class TodoAdapter : ListAdapter<Todo, TodoViewHolder>(TodoDiffCallback()) {

  private fun getActualList(): MutableList<Todo> = currentList

  fun addToList(item: Todo) {
    var actualList: MutableList<Todo> = getActualList().toMutableList()
    if (actualList.size > 0) {
      actualList.add(item)
    } else {
      actualList = mutableListOf()
      actualList.add(item)
    }

    update(actualList)
  }

  private fun updateToList(item: Todo) {
    val actualList = getActualList()
    val index = actualList.indexOf(item)
    actualList[index].done = !actualList[index].done

    update(actualList)
  }

  private fun update(list: List<Todo>) {
    submitList(list)
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): TodoViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.item_todo_list, parent, false)
    return TodoViewHolder(view)
  }

  override fun onBindViewHolder(
    holder: TodoViewHolder,
    position: Int
  ) {
    holder.apply {
      val item = getItem(position)
      bind(item)
      itemView.setOnClickListener {
        updateToList(item)
      }
    }
  }
}