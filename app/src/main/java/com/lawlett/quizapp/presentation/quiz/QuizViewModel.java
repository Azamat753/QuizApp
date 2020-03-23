package com.lawlett.quizapp.presentation.quiz;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lawlett.quizapp.data.model.Question;
import com.lawlett.quizapp.data.model.QuizResult;
import com.lawlett.quizapp.data.remote.IQuizApiClient;
import com.lawlett.quizapp.data.remote.QuizApiClient;
import com.lawlett.quizapp.utils.SingleLiveEvent;

import java.util.Date;
import java.util.List;

public class QuizViewModel extends ViewModel {
    Integer count;
    //todo
    List<Question> listQuestion;

    MutableLiveData<List<Question>> dataWithQuestion = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();
    SingleLiveEvent<Void> finishEvent = new SingleLiveEvent<>();

    public QuizViewModel() {
        currentQuestionPosition.setValue(0);
        count = 0;
    }

    public void init(int amount, Integer category, String difficulty) {
        isLoading.setValue(true);
    }

    void queryOnData(int amount, final Integer category, String difficulty) {
        new QuizApiClient().getQuestion(amount, category, difficulty, new IQuizApiClient.QuestionCallback() {
            @Override
            public void onSuccess(List<Question> questions) {
                isLoading.setValue(false);
                listQuestion = questions;
                dataWithQuestion.setValue(questions);
                dataWithQuestion.postValue(listQuestion);
                //todo postValue
                currentQuestionPosition.setValue(0);
            }

            @Override
            public void onFailure(Throwable t) {
                isLoading.setValue(false);
            }
        });
    }

    void onFinishQuiz() {
        QuizResult quizResult = new QuizResult(
                0,
                "",
                "",
                dataWithQuestion.getValue(),
                1,
                new Date()
        );
    }

    void onAnswerClick(int position, int selectedAnswerPosition) {
        if (listQuestion.size() > position && position >= 0) {
            listQuestion.get(position).setSelectedAnswersPosition(selectedAnswerPosition);
            listQuestion.get(position).setAnswered(true);
            dataWithQuestion.setValue(listQuestion);
            if (position + 1 == listQuestion.size()) {
                onFinishQuiz();
            } else {
                currentQuestionPosition.setValue(++count);
            }
        }
    }

    void onSkip() {
        if (listQuestion.size() >= currentQuestionPosition.getValue()) {
            listQuestion.get(currentQuestionPosition.getValue()).setAnswered(true);
            dataWithQuestion.setValue(listQuestion);
            currentQuestionPosition.setValue(++count);
            if (currentQuestionPosition.getValue() + 1 == listQuestion.size()) {
                onFinishQuiz();
            }
        }
    }
    void onBackPress() {
        if (currentQuestionPosition.getValue() != 0) {
            currentQuestionPosition.setValue(--count);
        } else {
            finishEvent.call();
        }
    }
}
