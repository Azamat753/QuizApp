package com.lawlett.quizapp.data.local;

import com.lawlett.quizapp.data.model.QuizResult;

public class HistoryStorage {
    private HistoryDao mHistoryDao;

    public HistoryStorage(HistoryDao historyDao) {
        this.mHistoryDao = historyDao;
    }


    void saveQuizResult(QuizResult quizResult) {
        mHistoryDao.insert(quizResult);
    }

    void deleteQuizResult(int id) {
        mHistoryDao.deleteById(id);
    }

    void deleteAllQuizResult() {
        mHistoryDao.deleteAll();
    }
}
