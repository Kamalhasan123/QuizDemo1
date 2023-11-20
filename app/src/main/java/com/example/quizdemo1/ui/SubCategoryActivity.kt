package com.example.quizdemo1.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizdemo1.R
import com.example.quizdemo1.adaptor.QuizAdaptor
import com.example.quizdemo1.models.Quiz

class SubCategoryActivity : AppCompatActivity() {

    private lateinit var subCategoryRecyclerView: RecyclerView
    private lateinit var quizAdapter: QuizAdaptor
    private lateinit var quizes: List<Quiz> // Make sure to initialize this with your data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)
        subCategoryRecyclerView = findViewById(R.id.subCategoryRecyclerView)
    }
}
