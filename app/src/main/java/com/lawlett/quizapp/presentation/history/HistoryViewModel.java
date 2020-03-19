package com.lawlett.quizapp.presentation.history;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lawlett.quizapp.data.model.History;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryViewModel extends ViewModel {

    MutableLiveData<List<History>> history = new MutableLiveData<>();

    public HistoryViewModel() {
        ArrayList<History> fakeHistory = new ArrayList<>();

        fakeHistory.add(new History(0, "mixed", "hard", 23, 15, new Date()));
        fakeHistory.add(new History(0, "mixed", "hard", 23, 15, new Date()));
        fakeHistory.add(new History(0, "mixed", "hard", 23, 15, new Date()));
        fakeHistory.add(new History(0, "mixed", "hard", 23, 15, new Date()));

        history.setValue(fakeHistory);
    }
}
