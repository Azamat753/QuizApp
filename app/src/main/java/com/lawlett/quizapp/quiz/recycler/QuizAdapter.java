package com.lawlett.quizapp.quiz.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lawlett.quizapp.R;
import com.lawlett.quizapp.data.model.Question;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {
    ArrayList<Question> list;

    public QuizAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuizViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView question_tv;
        Button one_type_btn, two_type_btn, first_btn, second_btn, third_btn, four_btn;

        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            question_tv = itemView.findViewById(R.id.question_tv);
            one_type_btn = itemView.findViewById(R.id.btn_one_type);
            first_btn = itemView.findViewById(R.id.first_btn);
            second_btn = itemView.findViewById(R.id.second_btn);
            third_btn = itemView.findViewById(R.id.third_btn);
            four_btn = itemView.findViewById(R.id.four_btn);
        }

        public void bind(Question question) {
            question_tv.setText(question.getQuestion());
            one_type_btn.setText(question.getCorrectAnswer());
//            two_type_btn.setText(question.getIncorrectAnswer(0);
            first_btn.setText(question.getIncorrectAnswer().get(0));
            second_btn.setText(question.getIncorrectAnswer().get(1));
            third_btn.setText(question.getIncorrectAnswer().get(2));
            four_btn.setText(question.getIncorrectAnswer().get(3));
        }
    }
}
