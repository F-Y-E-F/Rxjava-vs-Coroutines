package com.example.rxjava.retrofit.rxjava

import com.example.rxjava.retrofit.Post
import com.example.rxjava.retrofit.ToDo
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ToDosService {
    @GET("/todos")
    fun getToDos() : Single<List<ToDo>>


    @POST("/posts")
    fun addPost(@Body post: Post) : Observable<Post>
}