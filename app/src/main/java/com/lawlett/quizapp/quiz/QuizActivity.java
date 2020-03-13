package com.lawlett.quizapp.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lawlett.quizapp.R;
import com.lawlett.quizapp.data.model.Question;
import com.lawlett.quizapp.quiz.recycler.QuizAdapter;

import java.util.List;

public class QuizActivity extends AppCompatActivity {
    public static final String AMOUNT_EXTRA="amount";
    public static final String CATEGORY_EXTRA="category";
    public static final String DIFFICULTY_EXTRA="difficulty";

    private QuizViewModel quizViewModel;
    RecyclerView recyclerView;
    QuizAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        recyclerView = findViewById(R.id.quiz_recycler);
        adapter = new QuizAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        int amount = getIntent().getIntExtra("amount", 5);
        Integer category = getIntent().getIntExtra("category", 0);
        String difficulty = getIntent().getStringExtra("difficulty");

        quizViewModel = ViewModelProviders
                .of(this)
                .get(QuizViewModel.class);
        if (category == 8) category = null;
        if (difficulty.equals("all")) difficulty = null;
        quizViewModel.queryOnData(amount, category, difficulty);

        quizViewModel.dataWithRetrofit.observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                adapter.updateQuestions(questions);
            }
        });
    }
    public static void start(Context context, int amount, Integer category, String difficulty) {
        context.startActivity(new Intent(context, QuizActivity.class)
                .putExtra(AMOUNT_EXTRA, amount)
                .putExtra(CATEGORY_EXTRA, category)
                .putExtra(DIFFICULTY_EXTRA, difficulty));
    }
}