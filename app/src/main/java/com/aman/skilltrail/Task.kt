package com.aman.skilltrail

data class Task(
    val id: Int,
    val title: String,
    val track: String,
    val points: Int,
    val isDone: Boolean = false
)
