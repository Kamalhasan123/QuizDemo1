package com.example.quizdemo1.adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.quizdemo1.R
import com.example.quizdemo1.models.OptionQuiz
import com.example.quizdemo1.models.Quiz
import com.example.quizdemo1.ui.QuestionActivity

class QuizAdaptor(val context: Context, val quizes: List<Quiz>, val onItemClick: ((Int) -> Unit) // Add this parameter
) : RecyclerView.Adapter<QuizAdaptor.QuizViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.quiz_item_mathematics, parent, false)
        return QuizViewHolder(view)

    }

    override fun getItemCount(): Int {
        return quizes.size

    }


    inner class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemViewTitle: TextView = itemView.findViewById(R.id.quizTitle)
        var iconView: ImageView = itemView.findViewById(R.id.mathematicsIcon)
        var cardContainer: ConstraintLayout = itemView.findViewById(R.id.cardView)

        init {
            itemView.setOnClickListener {
                var subCategoryRecyclerView: RecyclerView = itemView.findViewById(R.id.subCategoryRecyclerView)

                onItemClick.invoke(adapterPosition)
                if (subCategoryRecyclerView.isVisible) {
                    subCategoryRecyclerView.visibility = View.GONE
                } else {
                    subCategoryRecyclerView.visibility = View.VISIBLE
                    // If you want to keep the button below the RecyclerView, you can set its visibility to GONE
                    // buttonBelowRecyclerView.visibility = View.VISIBLE
                }
            }
        }
        init {
            itemView.setOnClickListener()
        }

    }


    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val quiz = quizes[position]

        /* holder.itemViewTitle.text = quiz.title
        holder.iconView.setImageResource(quiz.iconResourceId)*/

        holder.itemViewTitle.text = quiz.title ?: ""
        holder.iconView.setImageResource(quiz.iconResourceId ?: R.drawable.mathematics)

        // Add click listener for the iconView


        holder.itemView.setOnClickListener {
            when (quiz.quizType) {
                1  -> {
                    // Open QuestionActivity for Mathematics

                    QuestionActivity.questions!!.clear()
                    QuestionActivity.options!!.clear()
                    QuestionActivity.correctAnswers!!.clear()

                    QuestionActivity.questions!!.add("What is the value of π (pi) to two decimal places?")
                    QuestionActivity.questions!!.add("Solve for x: 2x + 5 = 15")
                    QuestionActivity.questions!!.add("What is the square root of 144?")
                    QuestionActivity.questions!!.add("In a right-angled triangle, what is the length of the hypotenuse if the other two sides are 3 and 4?")
                    QuestionActivity.questions!!.add("Simplify: 3(2x - 5) = 12")
                    QuestionActivity.questions!!.add("What is the area of a rectangle with length 8 cm and width 5 cm?")
                    QuestionActivity.questions!!.add("If a = 3 and b = 7, what is the value of a^2 + b^2?")
                    QuestionActivity.questions!!.add("What is the sum of the angles in a triangle?")
                    QuestionActivity.questions!!.add("If the radius of a circle is 6 cm, what is its circumference?")
                    QuestionActivity.questions!!.add("Solve for x: 4x - 7 = 5")

                    QuestionActivity.options!!.add(OptionQuiz("3.14", "3.15", "3.16", "3.13"))

                    QuestionActivity.options!!.add(OptionQuiz("x = 5", "x = 7", "x = 10", "x = 15"))
                    QuestionActivity.options!!.add(OptionQuiz("9", "12", "15", "10"))
                    QuestionActivity.options!!.add(OptionQuiz("5", "7", "25", "√25"))
                    QuestionActivity.options!!.add(OptionQuiz("2x - 15", "6x - 15", "6x - 5", "6x + 15"))
                    QuestionActivity.options!!.add(OptionQuiz("13 cm²", "30 cm²", "40 cm²", "45 cm²"))
                    QuestionActivity.options!!.add(OptionQuiz("58", "58", "58", "58"))
                    QuestionActivity.options!!.add(OptionQuiz("90 degrees", "120 degrees", "180 degrees", "360 degrees"))
                    QuestionActivity.options!!.add(OptionQuiz("12π cm", "18π cm", "24π cm", "36π cm"))
                    QuestionActivity.options!!.add(OptionQuiz("x = 3", "x = 4", "x = 2", "x = 1"))

                    QuestionActivity.correctAnswers!!.add(1)
                    QuestionActivity.correctAnswers!!.add(2)
                    QuestionActivity.correctAnswers!!.add(2)
                    QuestionActivity.correctAnswers!!.add(2)
                    QuestionActivity.correctAnswers!!.add(1)
                    QuestionActivity.correctAnswers!!.add(2)
                    QuestionActivity.correctAnswers!!.add(0)
                    QuestionActivity.correctAnswers!!.add(2)
                    QuestionActivity.correctAnswers!!.add(3)
                    QuestionActivity.correctAnswers!!.add(2)

                    openQuestionActivity(quiz, showQuestion = true)

                }

                2 -> {
                    // Open QuestionActivity for English

                    QuestionActivity.questions!!.clear()
                    QuestionActivity.options!!.clear()
                    QuestionActivity.correctAnswers!!.clear()

                    QuestionActivity.questions!!.add("What is the plural form of 'child'?")
                    QuestionActivity.questions!!.add("Identify the antonym of 'brave'.")
                    QuestionActivity.questions!!.add("Which of the following is a pronoun?")
                    QuestionActivity.questions!!.add("What is the past tense of 'run'?")
                    QuestionActivity.questions!!.add("Choose the correct spelling: 'accommodate' or 'acommmodate'")
                    QuestionActivity.questions!!.add("What is the synonym for 'eloquent'?")
                    QuestionActivity.questions!!.add("Identify the part of speech for the word 'happiness'.")
                    QuestionActivity.questions!!.add("What is the correct punctuation for the end of a declarative sentence?")
                    QuestionActivity.questions!!.add("Select the correct sentence: 'She don't' or 'She doesn't'")
                    QuestionActivity.questions!!.add("What is the superlative form of 'good'?")

                    QuestionActivity.options!!.add(OptionQuiz("Children", "Childs", "Childes", "Childs'"))
                    QuestionActivity.options!!.add(OptionQuiz("Fearless", "Cowardly", "Bold", "Timid"))
                    QuestionActivity.options!!.add(OptionQuiz("Book", "Run", "He", "Jump"))
                    QuestionActivity.options!!.add(OptionQuiz("Ran", "Running", "Runned", "Runs"))
                    QuestionActivity.options!!.add(OptionQuiz("Accommodate", "Acommmodate", "Acommodate", "Accomodate"))
                    QuestionActivity.options!!.add(OptionQuiz("Articulate", "Inarticulate", "Verbose", "Taciturn"))
                    QuestionActivity.options!!.add(OptionQuiz("Verb", "Noun", "Adjective", "Adverb"))
                    QuestionActivity.options!!.add(OptionQuiz(".", "!", "?", ","))
                    QuestionActivity.options!!.add(OptionQuiz("She don't", "She doesn't", "She don`t", "She do not"))
                    QuestionActivity.options!!.add(OptionQuiz("Better", "Best", "Gooder", "Goodest"))

                    QuestionActivity.correctAnswers!!.add(0)
                    QuestionActivity.correctAnswers!!.add(1)
                    QuestionActivity.correctAnswers!!.add(2)
                    QuestionActivity.correctAnswers!!.add(0)
                    QuestionActivity.correctAnswers!!.add(0)
                    QuestionActivity.correctAnswers!!.add(0)
                    QuestionActivity.correctAnswers!!.add(1)
                    QuestionActivity.correctAnswers!!.add(0)
                    QuestionActivity.correctAnswers!!.add(1)
                    QuestionActivity.correctAnswers!!.add(1)


                    openQuestionActivity(quiz, showQuestion = true)

                }
                3 -> {
                    // Open QuestionActivity for Science

                    QuestionActivity.questions!!.clear()
                    QuestionActivity.options!!.clear()
                    QuestionActivity.correctAnswers!!.clear()

                    QuestionActivity.questions!!.add("What is the chemical symbol for water?")
                    QuestionActivity.questions!!.add("Which gas is responsible for the greenhouse effect?")
                    QuestionActivity.questions!!.add("Who is known as the 'Father of Modern Physics'?")
                    QuestionActivity.questions!!.add("What is the atomic number of carbon?")
                    QuestionActivity.questions!!.add("Which planet is known as the 'Red Planet'?")
                    QuestionActivity.questions!!.add("What is the largest organ in the human body?")
                    QuestionActivity.questions!!.add("Which element has the chemical symbol 'O'?")
                    QuestionActivity.questions!!.add("What is the SI unit of force?")
                    QuestionActivity.questions!!.add("Who discovered penicillin?")
                    QuestionActivity.questions!!.add("What is the process by which plants make their own food?")

                    QuestionActivity.options!!.add(OptionQuiz("H2O", "CO2", "O2", "N2"))
                    QuestionActivity.options!!.add(OptionQuiz("Carbon Dioxide", "Oxygen", "Methane", "Nitrogen"))
                    QuestionActivity.options!!.add(OptionQuiz("Isaac Newton", "Galileo Galilei", "Albert Einstein", "Niels Bohr"))
                    QuestionActivity.options!!.add(OptionQuiz("5", "12", "6", "8"))
                    QuestionActivity.options!!.add(OptionQuiz("Mars", "Venus", "Jupiter", "Mercury"))
                    QuestionActivity.options!!.add(OptionQuiz("Heart", "Skin", "Liver", "Lungs"))
                    QuestionActivity.options!!.add(OptionQuiz("Oxygen", "Ozone", "Gold", "Carbon"))
                    QuestionActivity.options!!.add(OptionQuiz("Newton", "Joule", "Watt", "Tesla"))
                    QuestionActivity.options!!.add(OptionQuiz("Marie Curie", "Alexander Fleming", "Louis Pasteur", "Joseph Lister")
                    )
                    QuestionActivity.options!!.add(OptionQuiz("Photosynthesis", "Respiration", "Digestion", "Transpiration"))

                    QuestionActivity.correctAnswers!!.add(0)
                    QuestionActivity.correctAnswers!!.add(0)
                    QuestionActivity.correctAnswers!!.add(2)
                    QuestionActivity.correctAnswers!!.add(2)
                    QuestionActivity.correctAnswers!!.add(0)
                    QuestionActivity.correctAnswers!!.add(1)
                    QuestionActivity.correctAnswers!!.add(0)
                    QuestionActivity.correctAnswers!!.add(1)
                    QuestionActivity.correctAnswers!!.add(1)
                    QuestionActivity.correctAnswers!!.add(0)

                    openQuestionActivity(quiz, showQuestion = true)

                }


                4 -> {

                    // Open QuestionActivity for General Knowledge

                    QuestionActivity.questions!!.clear()
                    QuestionActivity.options!!.clear()
                    QuestionActivity.correctAnswers!!.clear()

                    QuestionActivity.questions!!.add("Which is the only planet known to support life?")
                    QuestionActivity.questions!!.add("What is the largest mammal in the world?")
                    QuestionActivity.questions!!.add("Who wrote 'Romeo and Juliet'?",)
                    QuestionActivity.questions!!.add("Which country is known as the 'Land of the Rising Sun'?",)
                    QuestionActivity.questions!!.add("What is the capital of Australia?",)
                    QuestionActivity.questions!!.add("Which is the largest ocean on Earth?",)
                    QuestionActivity.questions!!.add("What is the currency of Japan?",)
                    QuestionActivity.questions!!.add("Who painted the Mona Lisa?",)
                    QuestionActivity.questions!!.add("In which year did the Titanic sink?",)
                    QuestionActivity.questions!!.add("What is the largest desert in the world?")


                    QuestionActivity.options!!.add(OptionQuiz("Mars", "Venus", "Earth", "Jupiter"))
                    QuestionActivity.options!!.add(OptionQuiz("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"))
                    QuestionActivity.options!!.add(OptionQuiz("Charles Dickens", "William Shakespeare", "Jane Austen", "Mark Twain"))
                    QuestionActivity.options!!.add(OptionQuiz( "China", "Japan", "South Korea", "Vietnam"))
                    QuestionActivity.options!!.add(OptionQuiz( "Sydney", "Melbourne", "Canberra", "Brisbane"))
                    QuestionActivity.options!!.add(OptionQuiz( "Atlantic Ocean", "Indian Ocean", "Southern Ocean", "Pacific Ocean"))
                    QuestionActivity.options!!.add(OptionQuiz("Yuan", "Won", "Yen", "Ringgit"))
                    QuestionActivity.options!!.add(OptionQuiz("Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"))
                    QuestionActivity.options!!.add(OptionQuiz("1912", "1905", "1920", "1915"))
                    QuestionActivity.options!!.add(OptionQuiz("Gobi Desert", "Sahara Desert", "Arabian Desert", "Antarctica"))


                    QuestionActivity.correctAnswers!!.add(2)
                    QuestionActivity.correctAnswers!!.add(1)
                    QuestionActivity.correctAnswers!!.add(1)
                    QuestionActivity.correctAnswers!!.add(1)
                    QuestionActivity.correctAnswers!!.add(2)
                    QuestionActivity.correctAnswers!!.add(3)
                    QuestionActivity.correctAnswers!!.add(2)
                    QuestionActivity.correctAnswers!!.add(2)
                    QuestionActivity.correctAnswers!!.add(0)
                    QuestionActivity.correctAnswers!!.add(3)

                    openQuestionActivity(quiz, showQuestion = true)

                }
                // Add more cases for different quiz types
                else -> {

                }
            }
        }
    }


    fun openQuestionActivity(quiz: Quiz, showQuestion: Boolean = false) {
        val intent = Intent(context, QuestionActivity::class.java)
        intent.putExtra("quizTitle", quiz.title ?: "")
        intent.putExtra("quizIcon", quiz.iconResourceId ?: R.drawable.mathematics)
        intent.putExtra("quizType", quiz.quizType)

        // Pass a boolean flag to indicate whether to show questions and options
        intent.putExtra("showQuestion", showQuestion)

        context.startActivity(intent)
    }

}


private fun View.setOnClickListener() {
}

