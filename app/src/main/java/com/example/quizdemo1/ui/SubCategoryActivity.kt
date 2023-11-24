package com.example.quizdemo1.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quizdemo1.R
import com.example.quizdemo1.adaptor.QuizAdaptor
import com.example.quizdemo1.adaptor.SubCatogeryAdaptor
import com.example.quizdemo1.models.Quiz

class SubCategoryActivity : AppCompatActivity() {

    private lateinit var subCategoryRecyclerView: RecyclerView
    private lateinit var quizAdapter: QuizAdaptor
    private lateinit var quizes: List<Quiz> // Make sure to initialize this with your data

    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)
        subCategoryRecyclerView = findViewById(R.id.subCategoryRecyclerView)

        val arrowback=findViewById<ImageView>(R.id.arrowBack)
        arrowback.setOnClickListener {
            startActivity(Intent(this@SubCategoryActivity,MainActivity::class.java))
        }

        setStatusBarColor()
//
//        var data:ArrayList<String>?=ArrayList()
//
//        data!!.add("Calculus")
//        data!!.add("Algebra")
//        data!!.add("Probablity")
//        data!!.add("variable")

        when(intent.extras!!.getString("checkType")){

            "Mathematics"->{
                var quizList=ArrayList<Quiz>()
                quizList.add(Quiz("Calculus", R.drawable.mathematics, 1)) // 1 represents Mathematics quiz type
                quizList.add(Quiz("Algebra", R.drawable.english, 2)) // 2 represents another quiz type
                quizList.add(Quiz("Probablity", R.drawable.science, 3)) // 3 represents another quiz type
                quizList.add(Quiz("Trigonometry", R.drawable.generalknowledge, 4)) //
                subCategoryRecyclerView.adapter=
                    SubCatogeryAdaptor(this@SubCategoryActivity, quizList, intent.extras!!.getString("checkType")
                )
            }
            "English" ->{
                var quizList=ArrayList<Quiz>()
                quizList.add(Quiz("Tense", R.drawable.mathematics, 1)) // 1 represents Mathematics quiz type
                quizList.add(Quiz("Grammar", R.drawable.english, 2)) // 2 represents another quiz type
                quizList.add(Quiz("Vocabulary", R.drawable.science, 3)) // 3 represents another quiz type
                quizList.add(Quiz("WordQuiz", R.drawable.generalknowledge, 4)) //
                subCategoryRecyclerView.adapter= SubCatogeryAdaptor(
                    this@SubCategoryActivity,
                    quizList,
                    intent.extras!!.getString("checkType")
                )
            }    "Science" ->{
                var quizList=ArrayList<Quiz>()
                quizList.add(Quiz("Physics", R.drawable.mathematics, 1)) // 1 represents Mathematics quiz type
                quizList.add(Quiz("Chemistry", R.drawable.english, 2)) // 2 represents another quiz type
                quizList.add(Quiz("Biolozy", R.drawable.science, 3)) // 3 represents another quiz type
                quizList.add(Quiz("GenralScience", R.drawable.generalknowledge, 4)) //
                subCategoryRecyclerView.adapter= SubCatogeryAdaptor(
                    this@SubCategoryActivity,
                    quizList,
                    intent.extras!!.getString("checkType")
                )
            }    "General Knowledge" ->{
                var quizList=ArrayList<Quiz>()
                quizList.add(Quiz("Puzzle", R.drawable.mathematics, 1)) // 1 represents Mathematics quiz type
                quizList.add(Quiz("LogicalQuestion", R.drawable.english, 2)) // 2 represents another quiz type
                quizList.add(Quiz("General", R.drawable.science, 3)) // 3 represents another quiz type
                quizList.add(Quiz("SocialScience", R.drawable.generalknowledge, 4)) //
                subCategoryRecyclerView.adapter= SubCatogeryAdaptor(this@SubCategoryActivity, quizList,intent.extras!!.getString("checkType"))
            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

            // Set your desired status bar color here (blue in this case)
            window.statusBarColor = getColor(R.color.blue)
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
            // Set the status bar icons and text color to white
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            getWindow().getDecorView().getWindowInsetsController()
                ?.setSystemBarsAppearance(0, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS);

        }
    }
}
