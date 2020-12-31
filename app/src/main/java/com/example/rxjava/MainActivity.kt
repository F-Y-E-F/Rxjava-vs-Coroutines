package com.example.rxjava

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjava.retrofit.ToDo
import com.example.rxjava.retrofit.rxjava.RxJavaApi
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableObserver
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val rxJavaApi = RxJavaApi()
        rxJavaApi.getToDos().subscribeWith(object : SingleObserver<List<ToDo>>{
            override fun onSubscribe(d: Disposable?) {}

            override fun onSuccess(it: List<ToDo>?) {
                Log.d("TAG","DONE" + Thread.currentThread().name)
                runOnUiThread {
                    toDosRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
                    toDosRecyclerView.adapter= ToDosRVAdapter(it!!)
                }
            }

            override fun onError(e: Throwable?) {
            }

        })

        Log.d("TAG",Thread.currentThread().name)
        text.text = "After response thread"
        coroutinesButton.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }

    }
}