package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var clickbutton: Button?=null
    var namePeople: EditText?=null
    var heightPeople: EditText?=null
    var weightPeople: EditText?=null
    var agePeople: EditText?=null
    var answer: TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickbutton=findViewById<Button>(R.id.button)
        var value = 0.0
        namePeople = findViewById<EditText>(R.id.editTextText)
        heightPeople = findViewById<EditText>(R.id.editTextNumber)
        weightPeople = findViewById<EditText>(R.id.editTextNumberDecimal)
        agePeople = findViewById<EditText>(R.id.editTextNumber2)
        answer = findViewById<TextView>(R.id.textView5)

        clickbutton?.setOnClickListener {
            clickbutton = findViewById<Button>(R.id.button)
            val namee = namePeople?.text.toString().trim().length
            val weightt = weightPeople?.text.toString().toDouble()
            val heightt = heightPeople?.text.toString().toInt()
            val agee = agePeople?.text.toString().toInt()
            var answerr = answer?.text
            var flag=true
            if (namee > 50 || namePeople?.text.toString().trim().isEmpty()) {
                namePeople?.error=getString(R.string.nameexception)
                flag=false
            }
            if (weightt > 250.0 || weightt < 0.0 || weightPeople?.text.toString().isEmpty()) {
                weightPeople?.error=getString(R.string.weightException)
                flag=false
            }
            if (heightt < 0 || heightt > 250 || heightPeople?.text.toString().isEmpty()) {
                heightPeople?.error=getString(R.string.heightException)
                flag=false
            }
            if (agee < 0 || agee > 150 || agePeople?.text.toString().isEmpty()) {
                agePeople?.error=getString(R.string.ageException)
                flag=false
            }
            if (flag){
                Toast.makeText(this, "Валидация завершена", Toast.LENGTH_SHORT).show()
                answerr = ((heightt * 15 + weightt * 20 - namee * 2) / (agee * 30)).toString()
                answer?.text = "Ответ: $answerr"
            }

        }
    }
}