package com.example.quizapps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView questionListView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionListView = findViewById(R.id.questionListView);

        List<Question> questionList = new ArrayList<>();
        // Add your Question objects to the list here
        questionList.add(new Question(
                "What is the capital of France?",
                "Paris", "Berlin", "Madrid", "Rome",
                "Paris"
        ));

        questionList.add(new Question(
                "Which planet is known as the Red Planet?",
                "Earth", "Mars", "Venus", "Jupiter",
                "Mars"
        ));

        com.example.quizapps.QuestionAdapter adapter = new com.example.quizapps.QuestionAdapter(this, R.layout.item_question, questionList);
        questionListView.setAdapter(adapter);
    }
}
