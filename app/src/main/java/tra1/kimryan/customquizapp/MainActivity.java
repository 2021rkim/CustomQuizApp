package tra1.kimryan.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView quizQuestion;
    EditText answerField;
    Button submit;
    String[] questions;
    String[] answers;
    int questionIndex;
    int totalCorrect = 0;
    int totalAnswered = 0;
    final String answerFieldHint = "answer the question here...";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questions = getResources().getStringArray(R.array.quizQuestions);
        answers = getResources().getStringArray(R.array.quizAnswers);
        setupPageItems();
    }

    protected void setupPageItems(){
        quizQuestion = findViewById(R.id.quizQuestion);
        answerField = findViewById(R.id.answerField);
        submit = findViewById(R.id.submitButton);
        questionIndex = randomInt(0, questions.length);
        quizQuestion.setText(questions[questionIndex]);
        answerField.setText("");
        answerField.setHint(answerFieldHint);
    }

    public void answer(View view){
        if(answerField.getText().equals(answers[questionIndex])){
            totalCorrect++;
        }
        totalAnswered++;
        questionIndex = randomInt(0, questions.length);
        quizQuestion.setText(questions[questionIndex]);
        answerField.setText("");
    }

    public static int randomInt(int min, int max){ //does not include max
        return new Random().nextInt(max - min) + min;
    }

}
