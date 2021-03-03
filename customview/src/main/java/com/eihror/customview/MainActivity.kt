package com.eihror.customview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

  private lateinit var buttonOne: CustomButton
  private lateinit var buttonTwo: CustomButton

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    buttonOne = findViewById(R.id.button_one)
    buttonTwo = findViewById(R.id.button_two)

    buttonOne.apply {
      setTitle(R.string.button_one_title)
      setDescription(R.string.button_one_description)
      setOnButtonClickListener {

      }
    }

    /*buttonTwo.apply {
      setTitle(R.string.button_two_title)
      setDescription(R.string.button_two_description)
      setOnButtonClickListener {

      }
    }*/
  }
}