package com.example.rxjava.retrofit.rxjava

import com.example.rxjava.retrofit.ToDo
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ToDosService {
    @GET("/todos")
    fun getToDos() : Observable<List<ToDo>>
}