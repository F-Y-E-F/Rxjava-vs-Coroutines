package com.example.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjava.retrofit.coroutines.ClientAPI
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        CoroutineScope(Dispatchers.IO)
            .launch {
                val todos = ClientAPI.client.getToDos()
                Log.d("TAG",Thread.currentThread().name)
                runOnUiThread {
                    toDosRecyclerView2.layoutManager = LinearLayoutManager(applicationContext)
                    toDosRecyclerView2.adapter= ToDosRVAdapter(todos)
                }
            }
        Log.d("TAG",Thread.currentThread().name)
        text2.text= "After response thread"
    }
}