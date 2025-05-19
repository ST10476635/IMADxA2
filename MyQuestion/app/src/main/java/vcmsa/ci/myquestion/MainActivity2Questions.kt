package vcmsa.ci.myquestion

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2Questions : AppCompatActivity() {

    private val questions = arrayOf(
        "Nelson Mandela was the president of South Africa in 1994","The World War II ended in 1945","The Berlin Wall fel in 1989","The Renaissance began in the 14th century","The United States declared independence in 1776"
    )
    private val answers = booleanArrayOf(true, true, true, true, true)
    private var currentQuestionindex = 0
    private var score = 0

    private fun displayQuestion() {
        val questionsText = findViewById<TextView>(R.id.txtQuestions)
        questionsText.text = questions[currentQuestionindex]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val isCorrect = userAnswer == answers[currentQuestionindex]

        if (isCorrect) {
            score++
            Toast.makeText(this@MainActivity2Questions, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity2Questions, "Incorrect!", Toast.LENGTH_SHORT).show()
        }
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity2_qustions)

        val trueButton = findViewById<Button>(R.id.btnTrue)
        val falseButton = findViewById<Button>(R.id.btnFalse)
        val nextButton = findViewById<Button>(R.id.btnNext)

        trueButton.setOnClickListener {
            checkAnswer(true)
        }
        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentQuestionindex++
            if (currentQuestionindex < questions.size) {

                displayQuestion() }
            else {
                // All questions answered should send user to next screen
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("Score", score)
                intent.putExtra("Total Questions", questions.size)
                startActivity(intent)
                finish()
            }
        }





            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }



