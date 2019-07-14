package com.example.mytodolistapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TodoListAdapter(private val context: Context, private val numbers: Array<String>, private val texts: Array<String>) : BaseAdapter() {
    private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // convertViewがある場合はそれを使い、ない場合は新しく作る
        val view = convertView ?: createView(parent)

        // positionから表示すべきtextのIDを得る
        val textId = getItem(position)

        // タグからViewHolderを取得
        val viewHolder = view.tag as ViewHolder

        viewHolder.text.text = texts[position]

        return view
    }

    override fun getItem(position: Int): Any = texts[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = texts.size

    private fun createView(parent: ViewGroup?) : View {
        val view = inflater.inflate(R.layout.todo_list_item, parent, false)
        view.tag = ViewHolder(view)
        return view
    }

    private class ViewHolder(view: View) {
        val number = view.findViewById<TextView>(R.id.todo_number)
        val text = view.findViewById<TextView>(R.id.todoText)
    }

}