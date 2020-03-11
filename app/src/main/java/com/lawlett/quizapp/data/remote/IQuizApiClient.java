package com.lawlett.quizapp.data.remote;

import android.content.Intent;

import com.lawlett.quizapp.data.model.Question;

import java.util.List;

public interface IQuizApiClient {
    void getQuestion( int amount,Integer category,String difficulty,QuestionCallback callback);

    interface QuestionCallback{
        void onSuccess(List<Question>questions);
        void onFailure(Exception e);
    }
}
