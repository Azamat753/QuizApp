package com.lawlett.quizapp.data.local;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.lawlett.quizapp.data.model.History;
import com.lawlett.quizapp.data.model.QuizResult;

import java.util.List;

public class HistoryStorage implements IHistoryStorage {
    private HistoryDao mHistoryDao;

    public HistoryStorage(HistoryDao historyDao) {
        this.mHistoryDao = historyDao;
    }

    public int saveQuizResult(QuizResult quizResult) {
        return (int) mHistoryDao.insert(quizResult);
    }

    @Override
    public void delete(int id) {
        mHistoryDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        mHistoryDao.deleteAll();
    }

    @Override
    public QuizResult get(int id) {
        return mHistoryDao.get(id);
    }

    @Override
    public LiveData<List<QuizResult>> getAll() {
        return mHistoryDao.getAll();
    }

//    public void deleteQuizResultByID(int id) {
//        mHistoryDao.deleteById(id);
//    }
//
//    public void deleteAllQuizResult() {
//        mHistoryDao.deleteAll();
//    }
//
//    public QuizResult getQuizResultById(int id) {
//        return mHistoryDao.get(id);
//    }
//
//    public LiveData<List<QuizResult>> getAll() {
//        return mHistoryDao.getAll();
//    }

    @Override
    public LiveData<List<History>> getAllHistory() {
        return null;
    }
}
