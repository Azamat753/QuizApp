package com.lawlett.quizapp.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.lawlett.quizapp.data.model.Question;
import com.lawlett.quizapp.data.remote.IQuizApiClient;
import com.lawlett.quizapp.data.remote.QuizApiClient;
import com.lawlett.quizapp.R;

import java.util.List;

public class QuizActivity extends AppCompatActivity {
private QuizViewModel quizViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quizViewModel = ViewModelProviders
                .of(this)
                .get(QuizViewModel.class);

    }
    public void setQuizViewModel(){
        quizViewModel.dataWithRetrofit.observe(this, new Observer<QuizApiClient>() {
            @Override
            public void onChanged(QuizApiClient quizApiClient) {

            }
        });
    }
}
