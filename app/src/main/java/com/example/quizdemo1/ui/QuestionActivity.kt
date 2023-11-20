package com.example.quizdemo1.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.Button
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.quizdemo1.R
import com.example.quizdemo1.databinding.ActivityQuestionBinding
import com.example.quizdemo1.models.OptionQuiz


class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    var cTimer: CountDownTimer? = null
    private lateinit var binding: ActivityQuestionBinding
    companion object{

        var questions :ArrayList<String>?=ArrayList()

        var options :ArrayList<OptionQuiz>?=ArrayList()

        var correctAnswers :ArrayList<Int>?=ArrayList()

    }

    private var currentQuestionIndex = 0
    private lateinit var progressBar: ProgressBar
    private var score=0
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    // Add a variable to track whether the quiz is submitted
    private var quizSubmitted = false
    // Add a variable to store skipped question count
    private var skippedQuestions = 0
    // Add a variable to store incorrect question count
    private var incorrectAnswers = 0
    // Add a variable to store total questions count
    private val totalQuestions = questions!!.size





    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve quiz information from Intent
        val quizTitle = intent.getStringExtra("quizTitle")
        val quizType = intent.getStringExtra("quizType")
        val quizIcon = intent.getIntExtra("quizIcon", R.drawable.mathematics) // Provide a default icon if needed

        supportActionBar?.title = quizTitle
        supportActionBar?.title = quizIcon.toString()
        supportActionBar?.title = quizType

        initViews()
        initControl()
        mObserver()
        setStatusBarColor()
        progressBar = findViewById(R.id.progressBarCircular)

        setUpViews()
        setUpNavigationDrawer()


        displayQuestion()

        // Retrieve the boolean flag from the intent
        val showQuestion = intent.getBooleanExtra("showQuestion", false)

        if (showQuestion) {
            // Set the visibility of your question and skip button
            binding.questionText.visibility = View.VISIBLE
            binding.skipButton.visibility = View.VISIBLE
        }



        binding.optionButtom1.setOnClickListener {
            checkAnswer(0)
        }
        binding.optionButtom2.setOnClickListener {
            checkAnswer(1)
        }
        binding.optionButtom3.setOnClickListener {
            checkAnswer(2)
        }
        binding.optionButtom4.setOnClickListener {
            checkAnswer(3)
        }
        binding.submitQuizButton.setOnClickListener {
            if (currentQuestionIndex < questions!!.size - 1) {
                // If the quiz is not finished, show a confirmation dialog
                showConfirmationDialog()
            } else {
                // If the quiz is finished, show the result screen
                showResults()
            }
        }

        // Example: Set the title of the ActionBar

    }

    private fun initViews() {

    }

    private fun initControl() {

    }

    private fun mObserver() {

    }


    private fun showConfirmationDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Confirm Submission")
        alertDialog.setMessage("Are you sure you want to submit the quiz?")
        alertDialog.setPositiveButton("Yes") { _, _ ->
            // User clicked Yes, show the result screen
            showResults()
        }
        alertDialog.setNegativeButton("No", null)
        alertDialog.show()
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
            getWindow().getDecorView().getWindowInsetsController()
                ?.setSystemBarsAppearance(0, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS);

        }
    }



    private fun callTimer() {
        progressBar.max = 20
        progressBar.progress = 20

        cTimer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val progress = (millisUntilFinished / 1000).toInt()
                progressBar.progress = progress
                binding.timmer.text = progress. toString()
            }

            override fun onFinish() {
                /* if (currentQuestionIndex < questions.size - 1) {
                     currentQuestionIndex++
                     binding.questionText.postDelayed({
                         displayQuestion()
                     }, 2000)
                 } else {
                     showResults()
                 }*/
                checkAnswer(-1)

            }
        }.start()
    }
    private fun correctButtonColors(buttonIndex: Int){
        when(buttonIndex){
            0 -> binding.optionButtom1.setBackgroundColor(Color.GREEN)
            1-> binding.optionButtom2.setBackgroundColor(Color.GREEN)
            2 -> binding.optionButtom3.setBackgroundColor(Color.GREEN)
            3 -> binding.optionButtom4.setBackgroundColor(Color.GREEN)
        }
    }
    private fun wrongButtonColors(buttonIndex:Int){
        when(buttonIndex){
            0 -> binding.optionButtom1.setBackgroundColor(Color.RED)
            1-> binding.optionButtom2.setBackgroundColor(Color.RED)
            2 -> binding.optionButtom3.setBackgroundColor(Color.RED)
            3 -> binding.optionButtom4.setBackgroundColor(Color.RED)
        }
    } private fun submitButton(){
        binding.optionButtom1.setBackgroundColor(Color.LTGRAY)
        binding.optionButtom2.setBackgroundColor(Color.LTGRAY)
        binding.optionButtom3.setBackgroundColor(Color.LTGRAY)
        binding.optionButtom4.setBackgroundColor(Color.LTGRAY)
    }
    private fun showResults(){
        // Toast.makeText(this,"Your score: $score out of ${questions.size}",Toast.LENGTH_SHORT.show())
        // binding.restart.isEnabled=true

        quizSubmitted = true
        cTimer?.cancel() // Cancel the timer if it's running

        // Calculate the results
        val correctAnswers = score
        val skippedAnswers = skippedQuestions
        val incorrectAnswers = totalQuestions - score - skippedQuestions

        // Show the result screen
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("totalQuestions", totalQuestions)
        intent.putExtra("correctAnswers", correctAnswers)
        intent.putExtra("incorrectAnswers", incorrectAnswers)
        intent.putExtra("skippedQuestions", skippedAnswers) // Pass skipped answers separately
        startActivity(intent)
        finish()
    }
    private fun displayQuestion() {
        try {
            cTimer!!.cancel()
        } catch (e: Exception) {

        }
        callTimer()
        // binding.timmer.setTextC        binding.optionButtom1.text=options[currentQuestionIndex][0]olor(Color.BLACK)

        try {
            binding.questionText.text = questions?.get(currentQuestionIndex) ?: ""
            binding.optionButtom1.text = options!![currentQuestionIndex].optiona.toString()
            binding.optionButtom2.text = options!![currentQuestionIndex].optionb.toString()
            binding.optionButtom3.text = options!![currentQuestionIndex].optionc.toString()
            binding.optionButtom4.text = options!![currentQuestionIndex].optiond.toString()
            submitButton()
            binding.skipButton.visibility =
                if (currentQuestionIndex == questions!!.size) View.GONE else View.VISIBLE

            // Hide the submit button until an answer is selected
            //binding.submitQuizButton.visibility = View.GONE
            binding.submitQuizButton.visibility =
                if (currentQuestionIndex == questions!!.size || quizSubmitted) View.VISIBLE else View.GONE
        }catch (e:Exception){

        }




    }
    @SuppressLint("SuspiciousIndentation")
    private fun checkAnswer(selectedAnswerIndex:Int) {
        val correctAnswerIndex = correctAnswers!![currentQuestionIndex].toInt()

        if (selectedAnswerIndex == correctAnswerIndex) {
            score++
            correctButtonColors(selectedAnswerIndex)
        } else {
            if (!quizSubmitted) {
                incorrectAnswers++
            }
            wrongButtonColors(selectedAnswerIndex)

            if (selectedAnswerIndex != -1) {
                // Highlight the correct answer only if the question is not skipped
                Handler().postDelayed({
                    correctButtonColors(correctAnswerIndex)
                }, 1000)
            }
        }
        val isSkipped = (selectedAnswerIndex == -1 /*&& currentQuestionIndex<=questions.size*/|| binding.timmer.text == "0")
        if (isSkipped ) {
            skippedQuestions++
        }

        if (currentQuestionIndex < questions!!.size - 1) {
            currentQuestionIndex++
            binding.questionText.postDelayed({ displayQuestion() }, 2000)
        } else {
            cTimer?.cancel()
            binding.submitQuizButton.visibility = View.VISIBLE
            binding.skipButton.visibility = View.GONE


        }
    }
    private fun restartQuiz(){
        quizSubmitted = false
        currentQuestionIndex = 0
        score = 0
        skippedQuestions = 0
        incorrectAnswers = 0
        displayQuestion()
        // binding.restart.isEnabled = false

    }

    fun setUpViews() {
        val skipButton: Button = findViewById(R.id.skipButton)
        skipButton.setOnClickListener {

            skippedQuestions++

            // Increment the currentQuestionIndex to move to the next question
            currentQuestionIndex++
            binding.submitQuizButton.visibility = View.VISIBLE
            skipButton.visibility = View.GONE
            // Display the next question
            displayQuestion()

        }
        /*
                skipButton.setOnClickListener {
                    // Increment the currentQuestionIndex to move to the next question
                    currentQuestionIndex++

                    // Check if the current question is the last question
                    if (currentQuestionIndex == questions.size - 1) {
                        // If it's the last question, hide the skip button and show the submit button
                        binding.submitQuizButton.visibility = View.VISIBLE
                        skipButton.visibility = View.GONE
                    }

                    // Display the next question
                    displayQuestion()
                }
        */
        val menubarImageView: AppCompatImageView = findViewById(R.id.menubarQuestion)
        menubarImageView.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }



    private fun setUpNavigationDrawer() {
        drawerLayout = findViewById(R.id.drawerLayout1)
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.nav_open,
            R.string.nav_close
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

    override fun onClick(v: View?) {

    }

}

