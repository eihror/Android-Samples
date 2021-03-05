package com.eihror.tests

import androidx.recyclerview.widget.DiffUtil

class TodoDiffCallback : DiffUtil.ItemCallback<Todo>() {

  override fun areItemsTheSame(
    oldItem: Todo,
    newItem: Todo
  ): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(
    oldItem: Todo,
    newItem: Todo
  ): Boolean {
    return oldItem == newItem
  }
}