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

class ScoreActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("Score",0)
        val totalQuestions = intent.getIntExtra("Total Questions",5)

        val scoreText = findViewById<TextView>(R.id.txtScore)
        val feedBackText = findViewById<TextView>(R.id.txtFeedback)
        val reviewButton = findViewById<Button>(R.id.btnReview)
        val exitButton = findViewById<Button>(R.id.btnExit)

        scoreText.text = "Your Score: $score/$totalQuestions"

        val feedback = when{
            (score >= 4) -> {
                "Excellent Work! You know your stuff."
            }

            (score >= 3) -> {
                "Good job! You got a decent memory"
            }

            else -> {
                "Keep practicing! History is important."
            }
        }
        feedBackText.text = feedback

        reviewButton.setOnClickListener {
            val intent = Intent(this,ReviewActivity::class.java)
            startActivity(intent)// transfer user to next screen
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


