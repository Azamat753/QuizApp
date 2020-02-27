package com.lawlett.quizapp;

import android.app.Application;

import com.lawlett.data.QuizRepository;

public class App extends Application {
    private static QuizRepository quizRepository;
    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }


    public static App getInstance() {
        return instance;
    }

    public static QuizRepository getDatabase() {
        return quizRepository;
    }
}
