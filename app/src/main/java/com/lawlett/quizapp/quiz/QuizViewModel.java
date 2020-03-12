package com.lawlett.quizapp.quiz;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lawlett.quizapp.data.model.Question;
import com.lawlett.quizapp.data.remote.IQuizApiClient;
import com.lawlett.quizapp.data.remote.QuizApiClient;

import java.util.List;

public class QuizViewModel extends ViewModel {

    public MutableLiveData<List<Question>> dataWithRetrofit = new MutableLiveData<>();

    void QueryOnData(int amount,Integer category,String difficulty) {
        new QuizApiClient().getQuestion(amount, category, difficulty, new IQuizApiClient.QuestionCallback() {
            @Override
            public void onSuccess(List<Question> questions) {
                dataWithRetrofit.setValue(questions);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
