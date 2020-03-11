package com.lawlett.quizapp.history.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.lawlett.quizapp.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    ArrayList<String> list;

    public HistoryAdapter() {
        list = new ArrayList<>();
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView category_tv, correct_answer_tv, difficulty_tv, data_tv;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            category_tv = itemView.findViewById(R.id.category_tv);
            correct_answer_tv = itemView.findViewById(R.id.correct_answer_tv);
            difficulty_tv = itemView.findViewById(R.id.difficult_tv_h);
            data_tv = itemView.findViewById(R.id.data_item);
        }

        public void bind(String s) {
            category_tv.setText("Mixed");
            correct_answer_tv.setText("Correct answers 8/10");
            difficulty_tv.setText("Difficulty:Easy");
            data_tv.setText("12 may 2019 20:32");
        }
    }
}
