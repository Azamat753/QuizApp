package com.lawlett.quizapp.history;

import androidx.lifecycle.LiveData;

import com.lawlett.quizapp.App;
import com.lawlett.quizapp.data.local.HistoryDao;
import com.lawlett.quizapp.data.local.HistoryStorage;
import com.lawlett.quizapp.data.model.History;
import com.lawlett.quizapp.data.model.QuizResult;

import java.util.List;

public class HistoryViewModel {
    private List<QuizResult> history;
}
