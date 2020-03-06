package com.lawlett.quizapp.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
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

        int amount = getIntent().getIntExtra("amount",5);
        Integer category = getIntent().getIntExtra("category",0);
        String difficulty = getIntent().getStringExtra("difficulty");
        quizViewModel = ViewModelProviders
                .of(this)
                .get(QuizViewModel.class);
        if (category == 8) category = null;
        if (difficulty=="any difficulty") difficulty= null;
        quizViewModel.QueryOnData(amount,category,difficulty);

        quizViewModel.dataWithRetrofit.observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {

            }
        });

    }

    public static void start (Context context,int amount ,Integer category,String difficulty ){
        context.startActivity(new Intent(context,QuizActivity.class )
                .putExtra("amount",amount)
                .putExtra("category",category)
                .putExtra("difficulty",difficulty));
    }
    }

