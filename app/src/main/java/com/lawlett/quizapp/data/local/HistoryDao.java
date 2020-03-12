package com.lawlett.quizapp.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.lawlett.quizapp.data.model.QuizResult;

import java.util.List;
@Dao
public interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(QuizResult quizResult);

    @Query("SELECT * FROM quiz_result WHERE id=:id")
    QuizResult get(int id);

    @Delete
    void delete(QuizResult quizResult);

    @Delete
    void deleteAll(QuizResult quizResult);

    @Query("SELECT * FROM quiz_result")
    LiveData<List<QuizResult>> getAll();
}
