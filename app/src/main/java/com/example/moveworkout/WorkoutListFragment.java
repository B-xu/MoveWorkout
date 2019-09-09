package com.example.moveworkout;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WorkoutListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private WorkoutAdapter mWorkoutAdapter;
    private RecyclerView.LayoutManager lm;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_workout_list, container, false);

        mRecyclerView = v.findViewById(R.id.workout_recycler_view);

        lm = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(lm);

        updateUI();

        return v;
    }

    private void updateUI() {


        mWorkoutAdapter = new WorkoutAdapter(PhaseTwoWorkout.get(getContext()).getWorkouts());
        mRecyclerView.setAdapter(mWorkoutAdapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }

    private class WorkoutHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Workout mWorkout;
        private TextView mTextView;
        public WorkoutHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_workout,parent, false));
            mTextView = itemView.findViewById(R.id.workout_name);
            itemView.setOnClickListener(this);
        }

        public void bind(Workout workout){
            mWorkout = workout;
            if (mWorkout.isHeader()){
                mTextView.setTextColor(getResources().getColor( R.color.grey));
                mTextView.setTypeface(Typeface.DEFAULT_BOLD);
                mTextView.setText(mWorkout.getName());
                mTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,23);
                itemView.setPadding(dpToPx(4),dpToPx(4),dpToPx(4),dpToPx(6));
            } else {
                mTextView.setTextColor(getResources().getColor(android.R.color.black));
                itemView.setPadding(dpToPx(4),dpToPx(4),dpToPx(4),dpToPx(4));
                mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                mTextView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                mTextView.setTypeface(Typeface.DEFAULT);
                mTextView.setText(mWorkout.getName());
            }


        }


        @Override
        public void onClick(View view) {
            Intent intent = WorkoutPagerActivity.newIntent(getContext(), mWorkout.getUUID());
            startActivity(intent);
        }
    }

    private class WorkoutAdapter extends RecyclerView.Adapter<WorkoutHolder>{
        private List<Workout> mWorkoutList;
        public WorkoutAdapter(List<Workout> workouts) {
            mWorkoutList = workouts;
        }

        @NonNull
        @Override
        public WorkoutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new WorkoutHolder(LayoutInflater.from(getActivity()), parent);
        }


        @Override
        public void onBindViewHolder(@NonNull WorkoutHolder holder, int position) {
            holder.bind(mWorkoutList.get(position));
        }

        @Override
        public int getItemCount() {
            return mWorkoutList.size();
        }
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
