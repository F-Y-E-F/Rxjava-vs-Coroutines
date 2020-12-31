package com.example.rxjava

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjava.retrofit.ToDo
import kotlinx.android.synthetic.main.todo_card.view.*

class ToDosRVAdapter(private val listOfToDos:List<ToDo>):RecyclerView.Adapter<ToDoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_card,parent,false))
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.todoId.text = listOfToDos[holder.adapterPosition].id.toString()
        holder.todoUserId.text = listOfToDos[holder.adapterPosition].userId.toString()
        holder.todoTitle.text = listOfToDos[holder.adapterPosition].title
        holder.todoCheck.isChecked = listOfToDos[holder.adapterPosition].completed
    }

    override fun getItemCount(): Int = listOfToDos.size
}

class ToDoViewHolder(v:View) : RecyclerView.ViewHolder(v){
    val todoId: TextView = v.todoId
    val todoUserId: TextView = v.todoUserId
    val todoTitle: TextView = v.todoTitle
    val todoCheck: CheckBox = v.todoCheck
}