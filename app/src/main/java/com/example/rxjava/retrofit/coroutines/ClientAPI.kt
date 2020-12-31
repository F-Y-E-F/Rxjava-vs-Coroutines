package com.example.rxjava.retrofit.coroutines

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ClientAPI {

    val client : ToDosServiceCoroutines by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create()).build().create(ToDosServiceCoroutines::class.java)
    }


}