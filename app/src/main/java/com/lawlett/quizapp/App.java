package com.lawlett.quizapp;

import android.app.Application;

import com.lawlett.quizapp.data.local.QuizLocalDataSource;
import com.lawlett.quizapp.data.remote.QuizApiClient;
import com.lawlett.quizapp.data.remote.QuizRepository;

public class App extends Application {
    private static QuizRepository quizRepository;
    
    @Override
    public void onCreate() {
        super.onCreate();
        quizRepository= new QuizRepository(
                new QuizLocalDataSource(),
                new QuizApiClient()
        );
    }
}
