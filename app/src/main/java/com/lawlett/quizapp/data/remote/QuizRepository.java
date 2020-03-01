package com.lawlett.quizapp.data.remote;

import com.lawlett.quizapp.data.local.QuizLocalDataSource;

public class QuizRepository {
    private QuizLocalDataSource localDataSource;
    private QuizApiClient remoteDataSource;

    public QuizRepository (QuizLocalDataSource localDataSource, QuizApiClient remoteDataSource){
        this.localDataSource=localDataSource;
        this.remoteDataSource=remoteDataSource;
    }
}