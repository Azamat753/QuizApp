package com.lawlett.quizapp.quiz;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lawlett.quizapp.data.model.Question;
import com.lawlett.quizapp.data.remote.IQuizApiClient;
import com.lawlett.quizapp.data.remote.QuizApiClient;

import java.util.List;

public class QuizViewModel extends ViewModel {
//Integer
    public MutableLiveData<QuizApiClient> dataWithRetrofit = new MutableLiveData<>();

    void QueryOnData() {
new QuizApiClient().getQuestion(10, "Art", "easy", new IQuizApiClient.QuestionCallback() {
    @Override
    public void onSuccess(List<Question> questions) {

    }

    @Override
    public void onFailure(Exception e) {

    }
});
    }
}