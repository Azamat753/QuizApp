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

    void deleteQuizResult(QuizResult quizResult) {
        mHistoryDao.delete(quizResult);
    }

    void deleteAllQuizResult(QuizResult quizResult) {
        mHistoryDao.deleteAll(quizResult);
    }
}
