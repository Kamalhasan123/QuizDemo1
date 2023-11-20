package com.example.quizdemo1.models

/*data class Quiz(
    var id:String ="",
    var title:String ="",
    var questions: MutableMap<String,Question> = mutableMapOf()
)*/
// Quiz.kt

data class Quiz(val title: String, val iconResourceId: Int, val quizType: Int)


