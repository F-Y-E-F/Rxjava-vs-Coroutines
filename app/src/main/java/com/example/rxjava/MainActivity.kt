package com.example.rxjava

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjava.retrofit.rxjava.RxJavaApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val rxJavaApi = RxJavaApi()
        rxJavaApi.getToDos()
            .subscribe {
                Log.d("TAG",Thread.currentThread().name)
                runOnUiThread {
                    toDosRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
                    toDosRecyclerView.adapter= ToDosRVAdapter(it)
                }
            }
        Log.d("TAG",Thread.currentThread().name)
        text.text = "After response thread"
        coroutinesButton.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }

    }
}