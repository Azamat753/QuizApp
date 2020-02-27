package com.lawlett.quizapp.main;

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

import com.lawlett.quizapp.R;

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

        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders
                .of(getActivity()).get(MainViewModel.class);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinnercat = view.findViewById(R.id.spinner_category);
        spinnerdif = view.findViewById(R.id.spinner_difficulty);
        seekBar = view.findViewById(R.id.main_seekBar);
        seekBar_amount = view.findViewById(R.id.q_amount_number);
        addInSpinner();
        addInSpinner2();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar_amount.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void addInSpinner() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Бишкек");
        arrayList.add("Чуй");
        arrayList.add("Нарын");
        arrayList.add("Талас");
        arrayList.add("Баткен");
        arrayList.add("Ош");
        arrayList.add("Джалал-Абад");
        arrayList.add("Москва");
        arrayList.add("Лондон");

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

    public void addInSpinner2() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Бишкек");
        arrayList.add("Чуй");
        arrayList.add("Нарын");
        arrayList.add("Талас");
        arrayList.add("Баткен");
        arrayList.add("Ош");
        arrayList.add("Джалал-Абад");
        arrayList.add("Москва");
        arrayList.add("Лондон");

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