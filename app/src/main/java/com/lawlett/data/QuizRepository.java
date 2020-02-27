package com.lawlett.data;

public class QuizRepository {
    private QuizLocalDataSource localDataSource;
    private QuizRemoteDataSource remoteDataSource;

    public QuizRepository (QuizLocalDataSource localDataSource,QuizRemoteDataSource remoteDataSource){
        this.localDataSource=localDataSource;
        this.remoteDataSource=remoteDataSource;

    }
}
