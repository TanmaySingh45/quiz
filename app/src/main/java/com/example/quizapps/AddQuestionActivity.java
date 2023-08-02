package com.example.quizapps;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddQuestionActivity extends Activity {

    private EditText questionEditText, option1EditText, option2EditText, option3EditText, option4EditText, correctAnswerEditText;
    private Spinner numberOfQuestionsSpinner;
    private Button addQuestionButton;

    private List<Question> questionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        questionEditText = findViewById(R.id.questionEditText);
        option1EditText = findViewById(R.id.option1EditText);
        option2EditText = findViewById(R.id.option2EditText);
        option3EditText = findViewById(R.id.option3EditText);
        option4EditText = findViewById(R.id.option4EditText);
        correctAnswerEditText = findViewById(R.id.correctAnswerEditText);
        numberOfQuestionsSpinner = findViewById(R.id.numberOfQuestionsSpinner);
        addQuestionButton = findViewById(R.id.addQuestionButton);

        // Populate the spinner with options
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.number_of_questions_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberOfQuestionsSpinner.setAdapter(spinnerAdapter);

        addQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQuestion();
            }
        });
    }

    private void addQuestion() {
        int numberOfQuestions = Integer.parseInt(numberOfQuestionsSpinner.getSelectedItem().toString());

        String questionText = questionEditText.getText().toString();
        String option1 = option1EditText.getText().toString();
        String option2 = option2EditText.getText().toString();
        String option3 = option3EditText.getText().toString();
        String option4 = option4EditText.getText().toString();
        String correctAnswer = correctAnswerEditText.getText().toString();

        Question question = new Question(questionText, option1, option2, option3, option4, correctAnswer);
        questionList.add(question);

        // Clear input fields
        questionEditText.getText().clear();
        option1EditText.getText().clear();
        option2EditText.getText().clear();
        option3EditText.getText().clear();
        option4EditText.getText().clear();
        correctAnswerEditText.getText().clear();

        Toast.makeText(this, "Question added!", Toast.LENGTH_SHORT).show();
    }
}

