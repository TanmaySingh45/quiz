package com.example.quizapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.quizapps.Question;
import com.example.quizapps.R;

import java.util.List;

public class QuestionAdapter extends ArrayAdapter<Question> {

    private List<Question> questionList;

    public QuestionAdapter(Context context, int resource, List<Question> questionList) {
        super(context, resource, questionList);
        this.questionList = questionList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_question, parent, false);
        }

        Question question = questionList.get(position);

        TextView questionTextView = convertView.findViewById(R.id.questionTextView);
        questionTextView.setText(question.getQuestionText());

        return convertView;
    }
}

