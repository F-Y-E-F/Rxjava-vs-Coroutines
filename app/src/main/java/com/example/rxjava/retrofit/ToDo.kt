package com.example.rxjava.retrofit

data class ToDo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean)