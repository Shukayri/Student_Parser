package com.example.studentparser



import kotlinx.android.synthetic.main.edit_row.view.*

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val context: Context, private val students: ArrayList<String>):
    RecyclerView.Adapter<MyAdapter.StudentViewHolder>() {
    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.edit_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val message = students[position]

        holder.itemView.apply {
            StudentRV.text = message

    }
}

    override fun getItemCount() = students.size
}