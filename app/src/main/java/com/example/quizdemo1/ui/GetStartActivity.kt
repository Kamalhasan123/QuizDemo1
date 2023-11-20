package com.example.quizdemo1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.quizdemo1.R

class getStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_start)

      /*  val button=findViewById<Button>(R.id.buttonStart)
        button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }*/
    }
}