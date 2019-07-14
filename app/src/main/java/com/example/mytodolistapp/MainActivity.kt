package com.example.mytodolistapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.view.button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val todoNumber = findViewById<EditText>(R.id.todo_number)
//        val number = todoNumber.text.toString()

        var countNumber = 1

//        val list: ListView? = findViewById<ListView>(R.id.todoList)
//        list?.adapter = TodoListAdapter(this)
//        val adapter = ArrayAdapter<String>(this, R.id.todoText)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val editText = findViewById<EditText>(R.id.inputText)
            val text = editText.text.toString()

            val pref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
            val numbers = pref.getStringSet("numbers", setOf())
            val texts = pref.getStringSet("texts", mutableSetOf())

            // TodoListにメモを追加
            texts.add(text)
            pref.edit().putStringSet("texts", texts).apply()

            val listView: ListView? = findViewById<ListView>(R.id.todoList)
            listView?.adapter = TodoListAdapter(this, numbers.toTypedArray(), texts.toTypedArray())
        }

        showTodoList()
    }

    private fun showTodoList() {
        val pref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val numbers = pref.getStringSet("numbers", setOf())
        val texts = pref.getStringSet("texts", setOf())

        val list: ListView? = findViewById<ListView>(R.id.todoList)
        list?.adapter = TodoListAdapter(this, numbers.toTypedArray(), texts.toTypedArray())
    }
}
