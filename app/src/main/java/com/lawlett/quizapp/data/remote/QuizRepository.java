package com.lawlett.quizapp.data.remote;

import androidx.lifecycle.LiveData;

import com.lawlett.quizapp.data.local.HistoryStorage;
import com.lawlett.quizapp.data.local.QuizLocalDataSource;
import com.lawlett.quizapp.data.model.History;
import com.lawlett.quizapp.data.model.Question;
import com.lawlett.quizapp.data.model.QuizResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizRepository {
    private HistoryStorage localDataSource;
    private QuizApiClient quizApiClient;

    public QuizRepository(HistoryStorage localDataSource, QuizApiClient quizApiClient) {
        this.localDataSource = localDataSource;
        this.quizApiClient = quizApiClient;
    }

    public int saveQuizResult(QuizResult quizResult) {
        return localDataSource.saveQuizResult(quizResult);
    }

    public LiveData<List<QuizResult>> getAll() {
        return localDataSource.getAll();
    }

    public QuizResult get(int id) {
        return localDataSource.getQuizResultById(id);
    }


    public void getQuestion(int amount, Integer category, String difficulty, final IQuizApiClient.QuestionCallback callback) {
        quizApiClient.getQuestion(amount, category, difficulty, new IQuizApiClient.QuestionCallback() {
            @Override
            public void onSuccess(List<Question> result) {
                for (int i = 0; i < result.size(); i++) {
                    result.set(i, shuffleAnswers(result.get(i)));
                }
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    private Question shuffleAnswers(Question question) {
        ArrayList<String> answers = new ArrayList<>();
        answers.add(question.getCorrectAnswer());
        answers.addAll(question.getIncorrectAnswers());
        Collections.shuffle(answers);
        question.setAnswers(answers);
        return question;
    }
}
