package com.lawlett.quizapp.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.lawlett.quizapp.data.model.QuizResult;

import java.util.List;

//@Query("SELECT * FROM quiz_result WHERE id=:id")
//    QuizResult get(int id);

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
    void getQuizResultById (int id ) {
        mHistoryDao.get(id);
    }
    public LiveData<List<QuizResult>>getAll(){
        return mHistoryDao.getAll();
    }
}
