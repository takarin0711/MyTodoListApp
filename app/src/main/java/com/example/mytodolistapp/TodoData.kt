package com.example.mytodolistapp

class TodoData {
    val id: Long
    val number: Int
    val text: String

    constructor(id: Long, number: Int, text: String) {
        this.id = id
        this.number = number
        this.text = text
    }
}