package com.lawlett.quizapp.data.remote;

import com.lawlett.quizapp.data.model.Question;

import java.util.List;

public interface IQuizApiClient {

    void getQuestion(QuestionCallback callback);

    interface QuestionCallback{
        void onSuccess(List<Question>questions);

        void onFailure(Exception e);
    }
}
