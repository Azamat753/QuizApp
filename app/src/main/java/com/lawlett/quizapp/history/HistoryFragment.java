package com.lawlett.quizapp.history;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lawlett.quizapp.R;
import com.lawlett.quizapp.core.CoreFragment;
import com.lawlett.quizapp.data.model.History;
import com.lawlett.quizapp.history.recycler.HistoryAdapter;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class HistoryFragment extends CoreFragment {
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
        recyclerView= view.findViewById(R.id.history_recycler);
        adapter = new HistoryAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));


    }
}
