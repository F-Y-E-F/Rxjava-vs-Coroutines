package com.example.rxjava.retrofit.coroutines

import com.example.rxjava.retrofit.ToDo
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ToDosServiceCoroutines {

    @GET("/todos")
    suspend fun getToDos() : List<ToDo>
}