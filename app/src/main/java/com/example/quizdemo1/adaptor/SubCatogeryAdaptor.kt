package com.example.quizdemo1.adaptor

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizdemo1.R
import com.example.quizdemo1.models.OptionQuiz
import com.example.quizdemo1.models.Quiz
import com.example.quizdemo1.ui.QuestionActivity

class SubCatogeryAdaptor(
    private val context: Context,
    private val subCatogery: ArrayList<Quiz>,
   var chektype: String?
) :
    RecyclerView.Adapter<SubCatogeryAdaptor.SubjectViewHolder>() {




    inner class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectName: TextView = itemView.findViewById(R.id.subCategoryTitle)
        //val subjectImage: ImageView = itemView.findViewById(R.id.imageGrade)
        // Assuming you have a TextView in your item_grade.xml
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.sub_catogery_item, parent, false)
        return SubjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val quiz = subCatogery[position]
        holder.subjectName.text = quiz.title
        holder.subjectName.setTextColor(Color.BLACK)


        holder.itemView.setOnClickListener {
            when (subCatogery[position].quizType) {
                1  -> {
                    // Open QuestionActivity for Mathematics

                    when(chektype){

                        "Mathematics"->{
                            
                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("Find the derivative of f(x) = 3x^2 + 2x + 1 with respect to x.")
                            QuestionActivity.questions!!.add("Evaluate the integral: ∫(4x^3 + 2x^2 - 5)dx")
                            QuestionActivity.questions!!.add("What is the limit of (x^2 - 1)/(x - 1) as x approaches 1?")
                            QuestionActivity.questions!!.add("Find the critical points of the function g(x) = x^3 - 6x^2 + 9x.")
                            QuestionActivity.questions!!.add("Solve the differential equation: dy/dx = 2x + 3")

                            QuestionActivity.options!!.add(OptionQuiz("6x + 2", "3x^2 + 2", "6x + 1", "3x^2 + 2x"))
                            QuestionActivity.options!!.add(OptionQuiz("x^4 + (2/3)x^3 - 5x", "x^4 + x^3 - 5x", "x^4 + (2/3)x^3", "3x^4 + 2x^3 - 5x"))
                            QuestionActivity.options!!.add(OptionQuiz("1", "0", "2", "undefined"))
                            QuestionActivity.options!!.add(OptionQuiz("x = 1, x = 3", "x = 1, x = 2", "x = 2, x = 3", "x = 1, x = 0"))
                            QuestionActivity.options!!.add(OptionQuiz("x^2 + 3x + C", "x^2 + 3x", "x^2 + 3x - 3", "x^2 + 3x + 2"))

                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(4)

                            openQuestionActivity(quiz, showQuestion = true)

                        }

                        "English"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("Which sentence is in the present simple tense?")
                            QuestionActivity.questions!!.add("Identify the sentence in the past continuous tense.")
                            QuestionActivity.questions!!.add("Choose the sentence written in the future perfect tense.")
                            QuestionActivity.questions!!.add("In which sentence is the present perfect continuous tense used?")
                            QuestionActivity.questions!!.add("Find the sentence in the past perfect tense.")

                            QuestionActivity.options!!.add(OptionQuiz("She is singing a song.", "She sings a song.", "She will sing a song.", "She has sung a song."))
                            QuestionActivity.options!!.add(OptionQuiz("I will be reading a book.", "They were playing tennis.", "He is swimming in the pool.", "She has been dancing all night."))
                            QuestionActivity.options!!.add(OptionQuiz("I have eaten lunch already.", "They will have completed the project.", "She was cooking dinner.", "We are watching a movie."))
                            QuestionActivity.options!!.add(OptionQuiz("I will go to the market tomorrow.", "She has been studying for hours.", "They are playing football now.", "He cooks dinner every night."))
                            QuestionActivity.options!!.add(OptionQuiz("He has already left.", "She will arrive soon.", "They had finished the work.", "I am working on a project."))

                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(2)

                            openQuestionActivity(quiz, showQuestion = true)
                        }
                        "Science"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("What is the SI unit of force?")
                            QuestionActivity.questions!!.add("Define the concept of acceleration.")
                            QuestionActivity.questions!!.add("What is the law of conservation of energy?")
                            QuestionActivity.questions!!.add("Explain the difference between mass and weight.")
                            QuestionActivity.questions!!.add("What is the formula for calculating electrical power?")

                            QuestionActivity.options!!.add(OptionQuiz("Watt", "Newton", "Joule", "Tesla"))
                            QuestionActivity.options!!.add(OptionQuiz("The rate of change of velocity", "The force applied to an object", "The speed of light", "The resistance of an object"))
                            QuestionActivity.options!!.add(OptionQuiz("Energy cannot be created or destroyed, only transformed", "Energy can be created out of nothing", "Energy is constantly decreasing", "Energy is only conserved in mechanical systems"))
                            QuestionActivity.options!!.add(OptionQuiz("Mass is the amount of matter in an object, while weight is the force of gravity acting on it", "Mass and weight are the same thing", "Mass is a measure of the force an object exerts, while weight is its inertia", "Mass and weight are only relevant in outer space"))
                            QuestionActivity.options!!.add(OptionQuiz("P = IV", "P = I/R", "P = V/I", "P = Fd"))

                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(2)

                            openQuestionActivity(quiz, showQuestion = true)
                        }
                        "General Knowledge"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("Replace the question mark with the correct number: 8, 6, 14, 10, 18, ?")
                            QuestionActivity.questions!!.add("What comes next in the sequence: 2, 6, 12, 20, ?")
                            QuestionActivity.questions!!.add("Solve the following riddle: I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?")
                            QuestionActivity.questions!!.add("If a plane crashes on the border of the United States and Canada, where do they bury the survivors?")
                            QuestionActivity.questions!!.add("I am taken from a mine, and shut up in a wooden case, from which I am never released, and yet I am used by almost every person. What am I?")

                            QuestionActivity.options!!.add(OptionQuiz("16", "12", "20", "22"))
                            QuestionActivity.options!!.add(OptionQuiz("24", "26", "28", "30"))
                            QuestionActivity.options!!.add(OptionQuiz("An echo", "A bell", "A river", "A shadow"))
                            QuestionActivity.options!!.add(OptionQuiz("In the nearest cemetery", "They don't bury survivors", "In the country of the person who died", "In a memorial site"))
                            QuestionActivity.options!!.add(OptionQuiz("Gold", "Coal", "Silver", "Diamond"))

                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(3)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(1)

                            openQuestionActivity(quiz, showQuestion = true)
                        }

                        }


                }

                2  -> {
                    // Open QuestionActivity for Mathematics

                    when(chektype){

                        "Mathematics"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("Solve the equation for x: 2x + 7 = 15")
                            QuestionActivity.questions!!.add("Factorize the expression: x^2 - 9")
                            QuestionActivity.questions!!.add("If 3x - 5 = 10, what is the value of x?")
                            QuestionActivity.questions!!.add("Simplify the expression: 2(3x - 4) + 5x")
                            QuestionActivity.questions!!.add("Find the value of x in the equation: 4(x - 2) = 12")

                            QuestionActivity.options!!.add(OptionQuiz("4", "5", "6", "7"))
                            QuestionActivity.options!!.add(OptionQuiz("(x - 3)(x + 3)", "(x - 9)", "(x + 3)(x + 3)", "(x - 3)(x - 3)"))
                            QuestionActivity.options!!.add(OptionQuiz("5", "4", "3", "2"))
                            QuestionActivity.options!!.add(OptionQuiz("11x - 8", "11x - 4", "10x - 8", "10x - 4"))
                            QuestionActivity.options!!.add(OptionQuiz("4", "5", "6", "7"))

                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(1)

                            openQuestionActivity(quiz, showQuestion = true)

                        }

                        "English"->{



                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("Identify the subject in the following sentence: 'The cat sat on the windowsill.'")
                            QuestionActivity.questions!!.add("Choose the correct sentence with proper punctuation.")
                            QuestionActivity.questions!!.add("Which sentence uses the correct form of the verb 'to be' in the past tense?")
                            QuestionActivity.questions!!.add("Identify the type of pronoun in the sentence: 'I gave her the book.'")
                            QuestionActivity.questions!!.add("Select the sentence with the correct use of 'their' and 'there'.")

                            QuestionActivity.options!!.add(OptionQuiz("cat", "sat", "windowsill", "on the"))
                            QuestionActivity.options!!.add(OptionQuiz("I like to read books.", "I like to read, books.", "I like to read books", "I like to read books;"))
                            QuestionActivity.options!!.add(OptionQuiz("She is going to the store yesterday.", "They were at the park tomorrow.", "He is reading a book now.", "We were happy to see her."))
                            QuestionActivity.options!!.add(OptionQuiz("Subject pronoun", "Object pronoun", "Possessive pronoun", "Demonstrative pronoun"))
                            QuestionActivity.options!!.add(OptionQuiz("Their going to the party next week.", "I left my keys over there.", "Their going to the store now.", "They're excited to visit their grandparents."))

                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(3)
                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(3)

                            openQuestionActivity(quiz, showQuestion = true)
                        }
                        "Science"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("What is the chemical symbol for gold?")
                            QuestionActivity.questions!!.add("Define the term 'molecule'.")
                            QuestionActivity.questions!!.add("What is the pH scale used to measure?")
                            QuestionActivity.questions!!.add("Identify the gas essential for combustion.")
                            QuestionActivity.questions!!.add("What is the formula for water?")

                            QuestionActivity.options!!.add(OptionQuiz("Au", "Ag", "G", "Go"))
                            QuestionActivity.options!!.add(OptionQuiz("A single atom", "A group of atoms bonded together", "A mixture of elements", "A compound"))
                            QuestionActivity.options!!.add(OptionQuiz("Temperature", "Density", "Acidity or alkalinity", "Pressure"))
                            QuestionActivity.options!!.add(OptionQuiz("Oxygen", "Nitrogen", "Carbon dioxide", "Hydrogen"))
                            QuestionActivity.options!!.add(OptionQuiz("H2O2", "CO2", "H2O", "O2"))

                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(3)
                            QuestionActivity.correctAnswers!!.add(2)

                            openQuestionActivity(quiz, showQuestion = true)

                        }
                        "General Knowledge"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("If all roses are red, and some flowers in this garden are roses, then:")
                            QuestionActivity.questions!!.add("John is twice as old as Mary was when John was as old as Mary is now. If Mary is currently 10 years old, how old is John?")
                            QuestionActivity.questions!!.add("Three people check into a hotel room that costs $30. They each contribute $10, handing $30 to the hotel clerk. Later, the hotel clerk realizes there was a mistake and that the room only cost $25. The hotel clerk gives $5 to the bellboy and asks him to return it to the guests. The bellboy, however, decides to keep $2 for himself and gives $1 back to each guest. Now, each guest has paid $9 (totaling $27) and the bellboy has kept $2. What happened to the missing dollar?")
                            QuestionActivity.questions!!.add("If a plane crashes on the border of the United States and Canada, where do they bury the survivors?")
                            QuestionActivity.questions!!.add("A man gave one son 10 cents and another son was given was 15 cents. What time is it?")

                            QuestionActivity.options!!.add(OptionQuiz("All flowers in the garden are red.", "Some flowers in the garden are not roses.", "All flowers in the garden are roses.", "None of the above."))
                            QuestionActivity.options!!.add(OptionQuiz("20 years old", "30 years old", "40 years old", "50 years old"))
                            QuestionActivity.options!!.add(OptionQuiz("There is no missing dollar.", "The bellboy stole the missing dollar.", "The guests were overcharged in the first place.", "The hotel clerk took the missing dollar."))
                            QuestionActivity.options!!.add(OptionQuiz("In the nearest cemetery", "They don't bury survivors", "In the country of the person who died", "In a memorial site"))
                            QuestionActivity.options!!.add(OptionQuiz("10 cents", "15 cents", "It's time to give them money", "The man has no concept of time"))

                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(3)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(4)

                            openQuestionActivity(quiz, showQuestion = true)

                        }

                    }


                }
                3  -> {
                    // Open QuestionActivity for Mathematics

                    when(chektype){

                        "Mathematics"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("What is the probability of rolling a sum of 7 with two six-sided dice?")
                            QuestionActivity.questions!!.add("If you draw a card from a standard deck of 52 cards, what is the probability of drawing a red card?")
                            QuestionActivity.questions!!.add("A bag contains 4 red balls and 6 blue balls. What is the probability of drawing a red ball?")
                            QuestionActivity.questions!!.add("If you flip a fair coin three times, what is the probability of getting exactly two heads?")
                            QuestionActivity.questions!!.add("In a group of 20 people, what is the probability that at least two people share the same birthday? (Assume non-leap year)")

                            QuestionActivity.options!!.add(OptionQuiz("1/6", "1/8", "1/12", "1/7"))
                            QuestionActivity.options!!.add(OptionQuiz("1/2", "1/4", "1/3", "1/5"))
                            QuestionActivity.options!!.add(OptionQuiz("2/5", "3/5", "1/4", "2/3"))
                            QuestionActivity.options!!.add(OptionQuiz("1/4", "3/8", "1/2", "5/8"))
                            QuestionActivity.options!!.add(OptionQuiz("0.588", "0.711", "0.888", "0.958"))

                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(2)

                            openQuestionActivity(quiz, showQuestion = true)

                        }

                        "English"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("What is the meaning of the word 'Ubiquitous'?")
                            QuestionActivity.questions!!.add("Choose the correct synonym for 'Benevolent'.")
                            QuestionActivity.questions!!.add("Identify the antonym for 'Opaque'.")
                            QuestionActivity.questions!!.add("What is the definition of 'Ephemeral'?")
                            QuestionActivity.questions!!.add("Select the correct usage of the word 'Ubiquitous' in a sentence.")

                            QuestionActivity.options!!.add(OptionQuiz("Rare", "Widespread", "Soothing", "Complicated"))
                            QuestionActivity.options!!.add(OptionQuiz("Malevolent", "Generous", "Cautious", "Vicious"))
                            QuestionActivity.options!!.add(OptionQuiz("Transparent", "Clear", "Lucid", "Opaque"))
                            QuestionActivity.options!!.add(OptionQuiz("Lasting a very short time", "Eternal", "Temporary", "Continuous"))
                            QuestionActivity.options!!.add(OptionQuiz("The elusive creature was ubiquitous in the forest.", "Ubiquitous clouds covered the sky.", "He ubiquitously avoided the issue.", "Ubiquitous troubles plagued the village."))

                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(1)

                            openQuestionActivity(quiz, showQuestion = true)
                        }
                        "Science"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("What is the powerhouse of the cell?")
                            QuestionActivity.questions!!.add("Define the term 'mitosis'.")
                            QuestionActivity.questions!!.add("Which gas do plants absorb during photosynthesis?")
                            QuestionActivity.questions!!.add("What is the function of red blood cells in the human body?")
                            QuestionActivity.questions!!.add("Identify the organ responsible for producing insulin.")

                            QuestionActivity.options!!.add(OptionQuiz("Nucleus", "Mitochondria", "Endoplasmic reticulum", "Golgi apparatus"))
                            QuestionActivity.options!!.add(OptionQuiz("The process of cell division resulting in two identical daughter cells", "The process of exchanging genetic material between homologous chromosomes", "The process of cellular respiration", "The process of creating sex cells"))
                            QuestionActivity.options!!.add(OptionQuiz("Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen"))
                            QuestionActivity.options!!.add(OptionQuiz("To transport oxygen to the cells", "To produce antibodies", "To digest food", "To store nutrients"))
                            QuestionActivity.options!!.add(OptionQuiz("Liver", "Pancreas", "Kidney", "Heart"))

                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(1)

                            openQuestionActivity(quiz, showQuestion = true)
                        }
                        "General Knowledge"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("What is the capital city of France?")
                            QuestionActivity.questions!!.add("Who wrote the play 'Romeo and Juliet'?")
                            QuestionActivity.questions!!.add("In which year did the Titanic sink?")
                            QuestionActivity.questions!!.add("Which planet is known as the 'Red Planet'?")
                            QuestionActivity.questions!!.add("Who is the current President of the United States?")

                            QuestionActivity.options!!.add(OptionQuiz("Berlin", "London", "Paris", "Madrid"))
                            QuestionActivity.options!!.add(OptionQuiz("William Shakespeare", "Jane Austen", "Charles Dickens", "Leo Tolstoy"))
                            QuestionActivity.options!!.add(OptionQuiz("1912", "1905", "1920", "1931"))
                            QuestionActivity.options!!.add(OptionQuiz("Venus", "Mars", "Jupiter", "Saturn"))
                            QuestionActivity.options!!.add(OptionQuiz("Joe Biden", "Donald Trump", "Barack Obama", "George W. Bush"))

                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(0)

                            openQuestionActivity(quiz, showQuestion = true)
                        }

                    }


                }


                4  -> {
                    // Open QuestionActivity for Mathematics

                    when(chektype){

                        "Mathematics"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("Find the sine of a 30-degree angle.")
                            QuestionActivity.questions!!.add("If sin(x) = 0.8, what is the value of cos(x)?")
                            QuestionActivity.questions!!.add("Calculate the tangent of a 45-degree angle.")
                            QuestionActivity.questions!!.add("If cos(y) = -0.6, what is the value of sin(y)?")
                            QuestionActivity.questions!!.add("Find the value of sec(theta) if cos(theta) = 0.5")

                            QuestionActivity.options!!.add(OptionQuiz("0.5", "0.7", "0.6", "0.8"))
                            QuestionActivity.options!!.add(OptionQuiz("0.6", "0.4", "0.2", "-0.8"))
                            QuestionActivity.options!!.add(OptionQuiz("1", "0.5", "√2/2", "2"))
                            QuestionActivity.options!!.add(OptionQuiz("-√0.64", "0.8", "-0.8", "0.6"))
                            QuestionActivity.options!!.add(OptionQuiz("2", "1/0.5", "1/√0.75", "2/√3"))

                            QuestionActivity.correctAnswers!!.add(3)
                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(1)

                            openQuestionActivity(quiz, showQuestion = true)

                        }

                        "English"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("What is the meaning of the word 'Obfuscate'?")
                            QuestionActivity.questions!!.add("Choose the correct synonym for 'Mellifluous'.")
                            QuestionActivity.questions!!.add("Identify the antonym for 'Serendipity'.")
                            QuestionActivity.questions!!.add("What is the definition of 'Sycophant'?")
                            QuestionActivity.questions!!.add("Select the correct usage of the word 'Ephemeral' in a sentence.")

                            QuestionActivity.options!!.add(OptionQuiz("Clarify", "Confuse", "Illuminate", "Elucidate"))
                            QuestionActivity.options!!.add(OptionQuiz("Harsh", "Smooth", "Loud", "Grating"))
                            QuestionActivity.options!!.add(OptionQuiz("Chance", "Fortuity", "Luck", "Misfortune"))
                            QuestionActivity.options!!.add(OptionQuiz("Leader", "Follower", "Rebel", "Conformist"))
                            QuestionActivity.options!!.add(OptionQuiz("The beauty of the sunset was ephemeral.", "He enjoyed the ephemeral breeze.", "Ephemeral facts are essential.", "Ephemeral challenges need lasting solutions."))

                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(3)
                            QuestionActivity.correctAnswers!!.add(0)

                            openQuestionActivity(quiz, showQuestion = true)
                        }
                        "Science"->{


                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("What is the chemical symbol for oxygen?")
                            QuestionActivity.questions!!.add("Define the term 'photosynthesis'.")
                            QuestionActivity.questions!!.add("Which planet is known as the Red Planet?")
                            QuestionActivity.questions!!.add("What is the function of the human heart?")
                            QuestionActivity.questions!!.add("Identify the process by which plants make their own food.")

                            QuestionActivity.options!!.add(OptionQuiz("O", "O2", "O3", "OX"))
                            QuestionActivity.options!!.add(OptionQuiz("The process by which plants convert light energy into chemical energy", "The process by which animals produce oxygen", "The process by which plants release carbon dioxide", "The process by which rocks transform into soil"))
                            QuestionActivity.options!!.add(OptionQuiz("Mars", "Venus", "Jupiter", "Saturn"))
                            QuestionActivity.options!!.add(OptionQuiz("To pump blood throughout the body", "To filter waste from the blood", "To produce insulin", "To digest food"))
                            QuestionActivity.options!!.add(OptionQuiz("Respiration", "Transpiration", "Photosynthesis", "Fermentation"))

                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(2)

                            openQuestionActivity(quiz, showQuestion = true)

                        }
                        "General Knowledge"->{

                            QuestionActivity.questions!!.clear()
                            QuestionActivity.options!!.clear()
                            QuestionActivity.correctAnswers!!.clear()

                            QuestionActivity.questions!!.add("What is the capital of India?")
                            QuestionActivity.questions!!.add("Who is known as the 'Father of the Constitution' in India?")
                            QuestionActivity.questions!!.add("What is the main economic system in a communist state?")
                            QuestionActivity.questions!!.add("Which river is the longest in the world?")
                            QuestionActivity.questions!!.add("What is the significance of the Magna Carta in history?")

                            QuestionActivity.options!!.add(OptionQuiz("Mumbai", "New Delhi", "Bangalore", "Kolkata"))
                            QuestionActivity.options!!.add(OptionQuiz("Jawaharlal Nehru", "Sardar Patel", "B.R. Ambedkar", "Mahatma Gandhi"))
                            QuestionActivity.options!!.add(OptionQuiz("Capitalism", "Socialism", "Communism", "Feudalism"))
                            QuestionActivity.options!!.add(OptionQuiz("Nile", "Amazon", "Ganges", "Yangtze"))
                            QuestionActivity.options!!.add(OptionQuiz("It established the principle that the king is subject to the law.", "It granted universal suffrage.", "It declared independence from colonial rule.", "It abolished slavery."))

                            QuestionActivity.correctAnswers!!.add(1)
                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(2)
                            QuestionActivity.correctAnswers!!.add(0)
                            QuestionActivity.correctAnswers!!.add(0)

                            openQuestionActivity(quiz, showQuestion = true)

                        }

                    }


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


    override fun getItemCount(): Int {
        return subCatogery.size
    }
}
