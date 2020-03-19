package com.lawlett.quizapp.presentation.quiz.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lawlett.quizapp.R;
import com.lawlett.quizapp.data.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {
    List<Question> list;
    Listener listener;

    public QuizAdapter() {
        list = new ArrayList<>();
    }

    public void updateQuestions(List<Question> list) {
        this.list = list;
        notifyDataSetChanged();
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
        LinearLayout mult_cont, boolean_cont;

        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            question_tv = itemView.findViewById(R.id.question_tv);
            one_type_btn = itemView.findViewById(R.id.btn_one_type);
            two_type_btn = itemView.findViewById(R.id.btn_two_type);
            first_btn = itemView.findViewById(R.id.first_btn);
            second_btn = itemView.findViewById(R.id.second_btn);
            third_btn = itemView.findViewById(R.id.third_btn);
            four_btn = itemView.findViewById(R.id.four_btn);
            mult_cont = itemView.findViewById(R.id.multiple_question_linear);
            boolean_cont = itemView.findViewById(R.id.type_question_linear);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onAnswerClick(getAdapterPosition());
                }
            });
        }

        public void bind(Question question) {
            question_tv.setText(question.getQuestion());
            if (question.getType().equals("boolean")) {
                mult_cont.setVisibility(View.GONE);
                boolean_cont.setVisibility(View.VISIBLE);
                one_type_btn.setText(question.getCorrectAnswer());
                two_type_btn.setText(question.getIncorrectAnswer().get(0));
            } else {
                mult_cont.setVisibility(View.VISIBLE);
                boolean_cont.setVisibility(View.GONE);
                first_btn.setText(question.getIncorrectAnswer().get(0));
                second_btn.setText(question.getIncorrectAnswer().get(1));
                third_btn.setText(question.getIncorrectAnswer().get(2));
                four_btn.setText(question.getCorrectAnswer());
            }
        }
    }
}
