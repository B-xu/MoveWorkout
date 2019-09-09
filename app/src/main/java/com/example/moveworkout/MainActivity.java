package com.example.moveworkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends SingleFragmentActivity {


    @Override
    public Fragment createFragment() {
        return new WorkoutListFragment();
    }
}
