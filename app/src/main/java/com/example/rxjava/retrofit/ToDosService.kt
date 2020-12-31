package com.example.rxjava.retrofit

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ToDosService {
    @GET("/todos")
    fun getToDos() : Observable<List<ToDo>>
}