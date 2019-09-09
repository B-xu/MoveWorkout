package com.example.moveworkout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.UUID;

public class WorkoutPagerActivity extends AppCompatActivity {
    private static String WORKOUT_ID = "myworkout";
    private ViewPager mViewPager;
    private List<Workout> mWorkouts;
    private UUID workoutID;
    private Button mNext;
    private Button mPrev;

    public static Intent newIntent(Context context, UUID uuid){
        Intent intent  = new Intent(context, WorkoutPagerActivity.class);
        intent.putExtra(WORKOUT_ID, uuid);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_pager);

        workoutID = (UUID) getIntent().getSerializableExtra(WORKOUT_ID);


        mViewPager = (ViewPager) findViewById(R.id.workout_view_pager);
        mWorkouts = PhaseTwoWorkout.get(this).getWorkouts();



        FragmentManager fm= getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return WorkoutFragment.newInstance(mWorkouts.get(position).getUUID());
            }

            @Override
            public int getCount() {
                return mWorkouts.size();
            }
        });

        for (int i=0; i< mWorkouts.size();i++){
            if (mWorkouts.get(i).getUUID().equals(workoutID)){
                mViewPager.setCurrentItem(i);
            }
        }


    }

}
