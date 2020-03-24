package com.lawlett.quizapp.data.local;

import androidx.lifecycle.LiveData;

import com.lawlett.quizapp.data.model.History;
import com.lawlett.quizapp.data.model.QuizResult;

import java.util.List;

public interface IHistoryStorage {
    int saveQuizResult(QuizResult quizResult);

    void delete(int id);

    void deleteAll();
QuizResult get(int id);

LiveData<List<QuizResult>>getAll();

LiveData<List<History>>getAllHistory();
}
