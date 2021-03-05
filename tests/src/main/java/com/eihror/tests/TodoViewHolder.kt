package com.eihror.tests

import android.view.View
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class TodoViewHolder(view: View) : ViewHolder(view) {

  private val title: AppCompatTextView = view.findViewById(R.id.text_view_todo_title)
  private val checkbox: AppCompatCheckBox = view.findViewById(R.id.checkbox_todo)

  fun bind(element: Todo) {
    title.text = element.description
    checkbox.isChecked = element.done
  }
}