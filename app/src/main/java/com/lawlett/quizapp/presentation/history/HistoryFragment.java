package com.lawlett.quizapp.presentation.history;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.lawlett.quizapp.R;
import com.lawlett.quizapp.core.CoreFragment;
import com.lawlett.quizapp.data.model.History;
import com.lawlett.quizapp.presentation.history.recycler.HistoryAdapter;

import java.util.List;

import static androidx.lifecycle.ViewModelProviders.*;
import static com.google.gson.reflect.TypeToken.get;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends CoreFragment {
    private HistoryViewModel mViewModel;
    RecyclerView recyclerView;
    HistoryAdapter adapter;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_history;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.history_recycler);
        adapter = new HistoryAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this)
                .get(HistoryViewModel.class);

        mViewModel.history.observe(getViewLifecycleOwner(), new Observer<List<History>>() {
            @Override
            public void onChanged(List<History> history) {
                adapter.update(history);
            }
        });


    }
}
