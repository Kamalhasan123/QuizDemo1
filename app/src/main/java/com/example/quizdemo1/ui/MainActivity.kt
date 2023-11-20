package com.example.quizdemo1.ui

import com.example.quizdemo1.adaptor.SubjectAdapter
import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizdemo1.R
import com.example.quizdemo1.adaptor.QuizAdaptor
import com.example.quizdemo1.databinding.ActivityMainBinding
import com.example.quizdemo1.models.Quiz


class MainActivity : AppCompatActivity() {
    lateinit var adaptor: QuizAdaptor
    private var quizList=ArrayList<Quiz>()
    var  recyclerView:RecyclerView?=null
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    private val subjectList = listOf("Mathematics", "English", "Science", "General Knowledge")
    private lateinit var subjectAdapter: SubjectAdapter // You need to create this adapter



    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // statusBar()

        recyclerView = findViewById(R.id.recyclerView)
        subjectAdapter = SubjectAdapter(this, subjectList)

     //   binding.rvGrade.layoutManager = LinearLayoutManager(this)
      //  binding.rvGrade.adapter = subjectAdapter


        setStatusBarColor()
        populatedDummyData()
        setUpViews()
        setUpNavigationDrawer()

/*
        binding.optionSelect.setOnClickListener {
            if (binding.rvGrade.isVisible) {
                binding.rvGrade.visibility = View.GONE
            } else {
                binding.rvGrade.visibility = View.VISIBLE
                // If you want to keep the button below the RecyclerView, you can set its visibility to GONE
                binding.optionSelect.visibility = View.VISIBLE
            }
        }
*/


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
                ?.setSystemBarsAppearance(0, APPEARANCE_LIGHT_STATUS_BARS);

        }
    }

    // MainActivity.kt
    private fun populatedDummyData() {
        quizList.add(Quiz("Mathematics", R.drawable.mathematics, 1)) // 1 represents Mathematics quiz type
        quizList.add(Quiz("English", R.drawable.english, 2)) // 2 represents another quiz type
        quizList.add(Quiz("Science", R.drawable.science, 3)) // 3 represents another quiz type
        quizList.add(Quiz("General Knowledge", R.drawable.generalknowledge, 4)) // 4 represents another quiz type
    }



    fun setUpViews() {
        setUpRecyclerView()

        val menubarImageView: AppCompatImageView = findViewById(R.id.menubar)
        menubarImageView.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    private fun setUpRecyclerView() {
        adaptor= QuizAdaptor(this, quizList) { selectedQuiz ->
            // Open the QuestionActivity
           // openQuestionActivity(selectedQuiz, showQuestion = true)
        }
        recyclerView?.layoutManager=GridLayoutManager(this,2)
        recyclerView?.adapter=adaptor
    }

    private fun setUpNavigationDrawer() {
        drawerLayout = findViewById(R.id.drawerLayout)
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.nav_open,
            R.string.nav_close
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }}