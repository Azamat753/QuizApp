package com.lawlett.quizapp.data.remote;

import com.lawlett.quizapp.data.local.QuizLocalDataSource;
import com.lawlett.quizapp.data.model.History;

import java.util.List;

public class QuizRepository {
    private QuizLocalDataSource localDataSource;
    private QuizApiClient remoteDataSource;

    public QuizRepository (QuizLocalDataSource localDataSource, QuizApiClient remoteDataSource){
        this.localDataSource=localDataSource;
        this.remoteDataSource=remoteDataSource;
    }
    public void getQuestion(IQuizApiClient.QuestionCallback callback){
        remoteDataSource.getQuestion(9,null,null,callback);
    }
}
