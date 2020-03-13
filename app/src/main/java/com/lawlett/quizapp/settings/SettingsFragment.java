package com.lawlett.quizapp.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lawlett.quizapp.R;
import com.lawlett.quizapp.core.CoreFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends CoreFragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_settings;
    }
}
