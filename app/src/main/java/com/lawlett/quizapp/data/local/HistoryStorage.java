package com.lawlett.quizapp.data.local;

import androidx.lifecycle.LiveData;

import com.lawlett.quizapp.data.model.QuizResult;

import java.util.List;

public class HistoryStorage {
    private HistoryDao mHistoryDao;

    public HistoryStorage(HistoryDao historyDao) {
        this.mHistoryDao = historyDao;
    }

    public int saveQuizResult(QuizResult quizResult) {
        return (int) mHistoryDao.insert(quizResult);
    }

    public void deleteQuizResultByID(int id) {
        mHistoryDao.deleteById(id);
    }

    public void deleteAllQuizResult() {
        mHistoryDao.deleteAll();
    }

    public QuizResult getQuizResultById(int id) {
        return mHistoryDao.get(id);
    }

    public LiveData<List<QuizResult>> getAll() {
        return mHistoryDao.getAll();
    }
}
