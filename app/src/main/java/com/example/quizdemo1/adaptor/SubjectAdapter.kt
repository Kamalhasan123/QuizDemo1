package com.example.quizdemo1.adaptor

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.quizdemo1.R

class SubjectAdapter(private val context: Context, private val subjectList: List<String>) :
    RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    inner class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectName: TextView = itemView.findViewById(R.id.textGrade)
        //val subjectImage: ImageView = itemView.findViewById(R.id.imageGrade)
// Assuming you have a TextView in your item_grade.xml
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_grade, parent, false)
        return SubjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val subject = subjectList[position]
        holder.subjectName.text = subject
        holder.subjectName.setTextColor(Color.RED)
      /*  holder.itemView.setOnClickListener {
            // Handle the click event, you can launch an activity or perform any action here
            Toast.makeText(context, "Clicked on ${subject.name}", Toast.LENGTH_SHORT).show()
        }*/
        // You can add any other bindings or click listeners here
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }
}
