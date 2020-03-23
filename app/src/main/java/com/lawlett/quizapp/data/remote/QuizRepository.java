package com.lawlett.quizapp.data.remote;

import com.lawlett.quizapp.data.local.QuizLocalDataSource;
import com.lawlett.quizapp.data.model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizRepository {
    private QuizLocalDataSource localDataSource;
    private QuizApiClient remoteDataSource;

    public QuizRepository(QuizLocalDataSource localDataSource, QuizApiClient remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public void getQuestion(int amount, Integer category, String difficulty, final IQuizApiClient.QuestionCallback callback) {
        remoteDataSource.getQuestion(amount, category, difficulty, new IQuizApiClient.QuestionCallback() {
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
