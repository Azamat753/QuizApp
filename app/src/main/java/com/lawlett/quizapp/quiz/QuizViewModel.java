package com.lawlett.quizapp.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lawlett.quizapp.data.model.Question;
import com.lawlett.quizapp.data.model.QuizResult;
import com.lawlett.quizapp.data.remote.IQuizApiClient;
import com.lawlett.quizapp.data.remote.QuizApiClient;

import java.util.Date;
import java.util.List;

public class QuizViewModel extends ViewModel {

    MutableLiveData<List<Question>> dataWithRetrofit = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();

    public void init(int amount, Integer category, String difficulty) {
        isLoading.setValue(true);
    }
        void queryOnData ( int amount, final Integer category, String difficulty){
            new QuizApiClient().getQuestion(amount, category, difficulty, new IQuizApiClient.QuestionCallback() {
                @Override
                public void onSuccess(List<Question> questions) {
                    isLoading.setValue(false);
                    dataWithRetrofit.setValue(questions);
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
                dataWithRetrofit.getValue(),
                1,
                new Date()
        );
    }

    void onAnswerClick(int selectedAnwserPosition) {

    }
        void onSkip(){
            //        Question question = questions.getValue().get(currentQuestionPosition.getValue()+1);
//        question.setSelectedAnswerPosition(-1);

            currentQuestionPosition.setValue(currentQuestionPosition.getValue() + 1);
        }

}
