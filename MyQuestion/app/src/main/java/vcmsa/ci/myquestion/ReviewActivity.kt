package vcmsa.ci.myquestion

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        val returnButton = findViewById<Button>(R.id.btnReturn)
        val exitButton = findViewById<Button>(R.id.btnEnd)

        val questions = arrayOf(

            "The World War II ended in 1945",
            "The Berlin Wall fel in 1989",
            "The Renaissance began in the 14th century",
            "The United States declared independence in 1776",
            "Did Apartheid end in 1998"
        )
        val answers = booleanArrayOf(true,true,false,true,false)

        val reviewTxt = findViewById<TextView>(R.id.txtReview2)

        var reviewContent = "Review questions and answers:\n\n"
        for (i in questions.indices){
            reviewContent+="${i+1}.${questions[0]}\n" //Displays the question number and the question
            reviewContent += "Correct answer: ${if (answers[i])"True" else "False"}\n\n"
        }
        reviewTxt.text = reviewContent

        returnButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) //Returns the user to the first screen
        }
        exitButton.setOnClickListener {
            finishAffinity()//Close all activities and exist app
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}