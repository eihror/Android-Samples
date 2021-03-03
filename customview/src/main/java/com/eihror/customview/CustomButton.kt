package com.eihror.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout

class CustomButton(
  context: Context,
  attributeSet: AttributeSet
) : ConstraintLayout(context, attributeSet) {

  private val title: AppCompatTextView
  private val description: AppCompatTextView
  private val checkbox: AppCompatCheckBox

  init {
    val layout = View.inflate(context, R.layout.component_custom_button, this)

    title = layout.findViewById(R.id.text_view_button_title)
    description = layout.findViewById(R.id.text_view_button_description)
    checkbox = layout.findViewById(R.id.checkbox_button)
  }

  fun setTitle(value: Int) {
    title.setText(value)
  }

  fun setDescription(value: Int) {
    description.setText(value)
  }

  fun setOnButtonClickListener(listener: ((View) -> Unit)) {
    this.setOnClickListener {
      checkbox.isChecked = !checkbox.isChecked
      listener.invoke(it)
    }
  }
}