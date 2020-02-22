package com.lawlett.quizapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {
    TextView tv_text;
    Button btn_increment, btn_decrement;
    private MainViewModel mViewModel;

    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = ViewModelProviders
                .of(getActivity())
                .get(MainViewModel.class);

        btn_increment = view.findViewById(R.id.btn_increment);
        btn_decrement = view.findViewById(R.id.btn_decrement);

        tv_text = view.findViewById(R.id.counter_tv);

        int pos = getArguments().getInt("pos");
        switch (pos) {
            case 0:
                tv_text.setVisibility(View.GONE);
                break;
            case 1:
                mViewModel.counter.observe(getActivity(), new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        tv_text.setText(integer.toString());
                    }
                });
                btn_decrement.setVisibility(View.GONE);
                btn_increment.setVisibility(View.GONE);
                break;
            case 2:
                mViewModel.history.observe(getActivity(), new Observer<ArrayList>() {
                    @Override
                    public void onChanged(ArrayList arrayList) {
                        tv_text.setText(arrayList.toString());
                    }
                });

                        btn_increment.setVisibility(View.GONE);
                btn_decrement.setVisibility(View.GONE);
                break;
        }

        btn_increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.onIncrementClick();

            }
        });

        btn_decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.onDecrementClick();

            }
        });
    }
}