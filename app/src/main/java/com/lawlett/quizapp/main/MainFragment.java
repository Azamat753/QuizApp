package com.lawlett.quizapp.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.lawlett.quizapp.quiz.QuizActivity;
import com.lawlett.quizapp.R;
import com.lawlett.quizapp.utils.SimpleOnSeekBarChangeListener;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    private TextView seekBar_amount;
    private MainViewModel mViewModel;
    SeekBar seekBar;
    Spinner spinnercat, spinnerdif;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders
                .of(getActivity()).get(MainViewModel.class);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinnercat = view.findViewById(R.id.spinner_category);
        spinnerdif = view.findViewById(R.id.spinner_difficulty);
        seekBar = view.findViewById(R.id.main_seekBar);
        seekBar_amount = view.findViewById(R.id.q_amount_number);
        SpinnerWithCategory();
        SpinnerWithDifficulty();

        view.findViewById(R.id.main_start_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), QuizActivity.class));
            }
        });
        seekBar.setOnSeekBarChangeListener(new SimpleOnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                super.onProgressChanged(seekBar, progress, fromUser);
                seekBar_amount.setText(String.valueOf(progress));
            }
        });
    }


    public void SpinnerWithCategory() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Any Category");
        arrayList.add("General Knowledge");
        arrayList.add("Entertainment:Books");
        arrayList.add("Entertainment:Film");
        arrayList.add("Entertainment:Music");
        arrayList.add("Entertainment:Musicals & Theatres");
        arrayList.add("Entertainment:Television");
        arrayList.add("Entertainment:Video Games");
        arrayList.add("Entertainment:Board Games");
        arrayList.add("Science:Nature");
        arrayList.add("Science:Computers");
        arrayList.add("Science:Mathematics");
        arrayList.add("Mythology");
        arrayList.add("Sports");
        arrayList.add("Geography");
        arrayList.add("History");
        arrayList.add("Politics");
        arrayList.add("Art");
        arrayList.add("Celebrities");
        arrayList.add("Animals");
        arrayList.add("Vehicles");
        arrayList.add("Entertainment:Comics");
        arrayList.add("Science:Gadgets");
        arrayList.add("Entertainment:Japanese Anime & Manga");
        arrayList.add("Entertainment:Japanese Cartoon & Animations");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercat.setAdapter(arrayAdapter);
        spinnercat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Выбран город: " + tutorialsName, Toast.LENGTH_LONG).show();

                Toast.makeText(getContext(), "" + tutorialsName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getContext(), "false", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void SpinnerWithDifficulty() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Any Difficulty");
        arrayList.add("Easy");
        arrayList.add("Medium");
        arrayList.add("Hard");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerdif.setAdapter(arrayAdapter);
        spinnerdif.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Выбран город: " + tutorialsName, Toast.LENGTH_LONG).show();

                Toast.makeText(getContext(), "" + tutorialsName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getContext(), "false", Toast.LENGTH_SHORT).show();
            }
        });
    }
}