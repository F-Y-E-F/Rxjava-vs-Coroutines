package com.example.rxjava

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjava.retrofit.RxJavaApi
import io.reactivex.rxjava3.schedulers.Schedulers
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

        text.text = "After response thread"
    }
}