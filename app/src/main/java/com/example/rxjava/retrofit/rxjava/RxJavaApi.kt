package com.example.rxjava.retrofit.rxjava

import com.example.rxjava.retrofit.Post
import com.example.rxjava.retrofit.ToDo
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RxJavaApi {

        private val toDosService: ToDosService

    init {
        val retrofit = Retrofit.Builder().addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
        toDosService = retrofit.create(ToDosService::class.java)
    }

    fun getToDos(): Single<List<ToDo>> {
        return toDosService.getToDos().observeOn(Schedulers.io())
    }

    fun addPost(post: Post): Observable<Post> {
        return toDosService.addPost(post).observeOn(Schedulers.io())
    }

}