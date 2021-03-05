package com.eihror.tests

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.UUID

class MainActivity : AppCompatActivity(R.layout.activity_main) {

  private lateinit var addTodo: FloatingActionButton
  private lateinit var todoRecycler: RecyclerView

  private val todoAdapter: TodoAdapter = TodoAdapter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setupView()
    setupActions()
  }

  private fun setupView() {
    addTodo = findViewById(R.id.button_add_todo)
    todoRecycler = findViewById(R.id.recycler_view_todo)

    todoRecycler.apply {
      adapter = todoAdapter
    }
  }

  private fun setupActions() {
    addTodo.setOnClickListener {
      val dialog = AlertDialog.Builder(this).create()

      dialog.apply {
        setTitle("Add an item")
        val editText = AppCompatEditText(this@MainActivity)
        setView(editText)

        setButton(DialogInterface.BUTTON_POSITIVE, "Add") { _, _ ->
          if (editText.text.toString().isNotEmpty()) {
            createTodoItem(editText.text.toString())
            dismiss()
          }
        }
        setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel") { _, _ ->
          dismiss()
        }
      }.show()
    }
  }

  private fun createTodoItem(value: String) {
    val todo = Todo(
      id = UUID.randomUUID().toString(),
      description = value,
      done = false
    )

    todoAdapter.addToList(item = todo)
  }
}