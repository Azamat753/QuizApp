package com.lawlett.quizapp.main;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lawlett.quizapp.App;
import com.lawlett.quizapp.R;
import com.lawlett.quizapp.data.model.Question;
import com.lawlett.quizapp.data.remote.IQuizApiClient;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private MainViewModel mViewModel;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     App.quizRepository.getQuestion(new IQuizApiClient.QuestionCallback() {
         @Override
         public void onSuccess(List<Question> questions) {
             for (Question question:questions){
                 Log.d("ololo",question.getQuestion()+""+question.getType());
             }
         }

         @Override
         public void onFailure(Throwable t) {

         }
     });
        mViewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel.class);

        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(3);

        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_recents:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_favorites:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_nearby:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }
        });
    }
}
