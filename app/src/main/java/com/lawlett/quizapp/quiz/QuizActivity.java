package com.lawlett.quizapp.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.lawlett.quizapp.data.model.Question;
import com.lawlett.quizapp.data.remote.IQuizApiClient;
import com.lawlett.quizapp.data.remote.QuizApiClient;
import com.lawlett.quizapp.R;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        new QuizApiClient().getQuestion(new IQuizApiClient.QuestionCallback() {
            @Override
            public void onSuccess(List<Question> questions) {
                Log.d("", "onSuccess: ");
            }

            @Override
            public void onFailure(Exception e) {
                Log.d("", "onFailure: "+e.getLocalizedMessage());

            }
        });
    }
}
