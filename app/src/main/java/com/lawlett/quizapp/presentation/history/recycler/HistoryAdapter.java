package com.lawlett.quizapp.presentation.history.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lawlett.quizapp.R;
import com.lawlett.quizapp.data.model.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    List<History> list;

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

    public void update(List<History> history) {
        this.list = history;
        notifyDataSetChanged();
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

        public void bind(History history) {
//            category_tv.setText(history.getCategory());
//            correct_answer_tv.setText(history.getCorrectAnswers());
//            difficulty_tv.setText(history.getDifficulty());
//            data_tv.setText(history.getCreateAt().toString());
        }
    }
}
