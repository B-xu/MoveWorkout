package com.example.moveworkout;

import androidx.fragment.app.Fragment;

public class WorkoutListActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new WorkoutListFragment();
    }
}
