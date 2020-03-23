package com.lawlett.quizapp.presentation.quiz.recycler;

import android.annotation.SuppressLint;
import android.text.Html;
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
        Button first_boolean_btn, second_boolean_btn, first_btn, second_btn, third_btn, four_btn;
        LinearLayout mult_cont, boolean_cont;

        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            question_tv = itemView.findViewById(R.id.question_tv);
            first_boolean_btn = itemView.findViewById(R.id.btn_one_type);
            second_boolean_btn = itemView.findViewById(R.id.btn_two_type);
            first_btn = itemView.findViewById(R.id.first_btn);
            second_btn = itemView.findViewById(R.id.second_btn);
            third_btn = itemView.findViewById(R.id.third_btn);
            four_btn = itemView.findViewById(R.id.four_btn);
            mult_cont = itemView.findViewById(R.id.multiple_question_linear);
            boolean_cont = itemView.findViewById(R.id.type_question_linear);

            first_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onAnswerClick(getAdapterPosition(), 0);
                }
            });
            second_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onAnswerClick(getAdapterPosition(), 1);
                }
            });
            third_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onAnswerClick(getAdapterPosition(), 2);
                }
            });
            four_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onAnswerClick(getAdapterPosition(),3);
                }
            });
            first_boolean_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onAnswerClick(getAdapterPosition(),0);
                }
            });
            second_boolean_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onAnswerClick(getAdapterPosition(),1);
                }
            });
        }

        public void bind(Question question) {
            question_tv.setText(Html.fromHtml(question.getQuestion()));
            if (question.getType().equals("boolean")) {
                mult_cont.setVisibility(View.GONE);
                boolean_cont.setVisibility(View.VISIBLE);
                first_boolean_btn.setText(Html.fromHtml(question.getCorrectAnswer()));
                second_boolean_btn.setText(Html.fromHtml(question.getIncorrectAnswer().get(0)));
            } else {
                mult_cont.setVisibility(View.VISIBLE);
                boolean_cont.setVisibility(View.GONE);
                first_btn.setText(Html.fromHtml(question.getIncorrectAnswer().get(0)).toString());
                try {
                    second_btn.setText(Html.fromHtml(question.getIncorrectAnswer().get(1)).toString());
                }catch (IndexOutOfBoundsException e){
                    e.printStackTrace();
                }
                third_btn.setText(Html.fromHtml(question.getIncorrectAnswer().get(2)).toString());
                four_btn.setText(Html.fromHtml(question.getCorrectAnswer()).toString());
            }
        }
        @SuppressLint("ResourceAsColor")
        public void reset(){
            first_btn.setTextColor(R.color.blue_for_btn);
            second_btn.setTextColor(R.color.blue_for_btn);
            third_btn.setTextColor(R.color.blue_for_btn);
            four_btn.setTextColor(R.color.blue_for_btn);
            first_boolean_btn.setTextColor(R.color.blue_for_btn);
            second_boolean_btn.setTextColor(R.color.blue_for_btn);
            first_btn.setBackgroundResource(R.color.white);
            second_btn.setBackgroundResource(R.color.white);
            third_btn.setBackgroundResource(R.color.white);
            four_btn.setBackgroundResource(R.color.white);
            first_boolean_btn.setBackgroundResource(R.color.white);
            second_boolean_btn.setBackgroundResource(R.color.white);

        }
    }
}
