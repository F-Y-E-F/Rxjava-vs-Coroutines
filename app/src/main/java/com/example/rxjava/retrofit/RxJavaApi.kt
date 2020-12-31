package com.example.rxjava.retrofit

import io.reactivex.Observable
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class RxJavaApi {

    private val toDosService: ToDosService

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        toDosService = retrofit.create(ToDosService::class.java)
    }

    fun getToDos () : Single<List<ToDo>> {
        return toDosService.getToDos()
    }

}