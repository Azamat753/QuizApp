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

import com.lawlett.quizapp.core.CoreFragment;
import com.lawlett.quizapp.quiz.QuizActivity;
import com.lawlett.quizapp.R;
import com.lawlett.quizapp.utils.SimpleOnSeekBarChangeListener;

import java.util.ArrayList;

public class MainFragment extends CoreFragment {
    private TextView seekBar_amount;
    private MainViewModel mViewModel;
    SeekBar seekBar;
    Spinner spinnercat, spinnerdif;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
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

//Button start
        view.findViewById(R.id.main_start_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizActivity.start(getActivity(),seekBar.getProgress(),

                        spinnercat.getSelectedItemPosition()+8,
                        spinnerdif.getSelectedItem().toString().toLowerCase());
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
}


/*todo
  Integer categoryId= null;         если категория null то запрос на any иначе (+8)
 if (categorySpinner.getSelectedIndex()=! 0) {
categoryId= categorySpinner.getSelectedIndex()+8;
*/
