package com.example.rxjava.retrofit.rxjava

import com.example.rxjava.retrofit.ToDo
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ToDosService {
    @GET("/todos")
    fun getToDos() : Single<List<ToDo>>
}