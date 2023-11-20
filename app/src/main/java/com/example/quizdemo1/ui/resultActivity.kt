package com.example.quizdemo1.ui

import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.Window
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.quizdemo1.R
import com.example.quizdemo1.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private var quizRestarted = false
    private var currentQuestionIndex = 0
    var cTimer: CountDownTimer? = null
    private lateinit var progressBar: ProgressBar

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.restart.setOnClickListener {
            restartQuiz()
        }
        setStatusBarColor()

        // Retrieve data from the intent
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)
        val correctAnswers = intent.getIntExtra("correctAnswers", 0)
        val incorrectAnswers = intent.getIntExtra("incorrectAnswers", 0)
        val skippedQuestions = intent.getIntExtra("skippedQuestions", 0)

        // Display the results
        binding.totalQuestionsTextView.text = "Total Questions: $totalQuestions"
        binding.correctAnswersTextView.text = "Correct Answers: $correctAnswers"
        binding.incorrectAnswersTextView.text = "Incorrect Answers: $incorrectAnswers"
        binding.skippedQuestionsTextView.text = "Skipped Questions: $skippedQuestions"
    }
    @RequiresApi(Build.VERSION_CODES.R)
    private fun setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

            // Set your desired status bar color here (blue in this case)
            window.statusBarColor = getColor(R.color.blue)
            // Set the status bar icons and text color to white
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            //icon color white
            window.decorView.windowInsetsController
                ?.setSystemBarsAppearance(0, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)
        }
    }
    private fun restartQuiz() {
        setResult(RESULT_OK)
        finish()
    }


}
