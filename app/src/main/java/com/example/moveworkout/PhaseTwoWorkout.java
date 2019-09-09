package com.example.moveworkout;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PhaseTwoWorkout {
    private static PhaseTwoWorkout sPhaseOneWorkout;
    private List<Workout> mWorkouts;

    private PhaseTwoWorkout(Context context) {
        mWorkouts = new ArrayList<>();

        mWorkouts.add(new Workout("Warmup", true, true, false, true, 1, 1,
                1, 5, 0, "", R.raw.wrists));

        mWorkouts.add(new Workout("Wrist Stretching", true, true, false, false, 1, 1,
                1, 5, 0, "", R.raw.wrists));
        mWorkouts.add(new Workout("Shoulder Shrug Circles", false, true, false,
                false, 10, 1, 1, 0, 10,
                "Move the shoulder as far in each direction as you can", R.raw.shoulder_shrug_circles));
        mWorkouts.add(new Workout("Plank", true, true, false, false, 1, 1, 1,
                    1, 0, "Push shoulders into ground, squeeze abs and butt", R.raw.plank));
        mWorkouts.add(new Workout("Reverse Plank", true, true, false, false, 1, 1, 1,
                1, 0, "Push your hips as high as possible while pulling your shoulders back. " +
                "Learn to tilt your pelvis in this position similar as the plank.", R.raw.reverse_plank));
        mWorkouts.add(new Workout("Hollow Body Hold", true, true, false, false, 1, 1, 1,
                1, 0, "Make sure your lower back is practically glued to the floor. Squeeze abs and glutes."
                , R.raw.hollow_hold));

        mWorkouts.add(new Workout("Hand Balancing", true, true, false, true, 1, 1,
                1, 5, 0, "", R.raw.wrists));

        mWorkouts.add(new Workout("Crow's Pose", true, true, false, false, 1, 1,
                1, 5, 0, "Put most of your weight under your knuckles. Press fingers into the floor when falling forward, " +
                "press palm into the floor when falling backwards. Rest as necessary.", R.raw.crows_pose));

        mWorkouts.add(new Workout("Strength & Control", true, true, false, true, 1, 1,
                1, 5, 0, "", R.raw.wrists));

        mWorkouts.add(new Workout("Pushups", false, true, false,
                false, 8, 3, 3, 1, 0 ,"", R.raw.pushup));
        mWorkouts.add(new Workout("Rowing", false, true, false,
                false, 8, 3, 3, 1, 0 ,"", R.raw.angled_row));
        mWorkouts.add(new Workout("Squats", false, true, false,
                false, 8, 3, 3, 1, 0 ,"", R.raw.squat));
        mWorkouts.add(new Workout("Bear Walk", true, true, false,
                false, 1, 1,1 , 5, 0, "Focus on getting your arms directly overhead and " +
                "raise your hips. With limited space 2-4 steps forwards and back is fine instead of a continuous walk. " +
                "Reach with your shoulders when going forwards, Push out of your shoulders when going backwards.", R.raw.bear_walk_new));

        mWorkouts.add(new Workout("Stretching & Mobility", true, true, false, true, 1, 1,
                1, 5, 0, "", R.raw.wrists));

        mWorkouts.add(new Workout("Child's Pose", true, false, false, false,
                2, 1, 1,0, 30,"Relax",  R.drawable.childs_pose_new ));
        mWorkouts.add(new Workout("Child's Pose with Lat Stretch", true, true, false, false,
                2, 1, 1,0, 30,"Look up through your armpit that's moved " +
                "towards the middle to intensify the stretch.",  R.raw.childs_pose_lat ));

        mWorkouts.add(new Workout("Chest Wall Stretch", true, true, false, false,
                2, 1, 1,1, 0,"Relax",  R.raw.chest_wall_stretch ));
        mWorkouts.add(new Workout("Wall Extensions", false, true, false,
                false, 10, 3, 3, 0, 10 ,"Do them lying on the floor. Only move as far as you can keep your elbows to the floor. Keep your lower back glued to the floor. " +
                "If you cannot reach the floor with your elbows at all, that is fine. Just try to reach.", R.raw.wall_extension));
        mWorkouts.add(new Workout("Bent Legged Calf Stretch", true, false, false, false,
                2, 1, 1,1, 0,"Relax",  R.mipmap.bent_leg_stretch ));
        mWorkouts.add(new Workout("Hamstring Lunge Stretch", true, true, false, false,
                2, 1, 1,1, 0,"Relax",  R.raw.hamstring_lunge_stretch ));
        mWorkouts.add(new Workout("Front Scale", false, true, false,
                false, 10, 3, 3, 0, 30 ,"Alternate sides. Lift your legs as high as you can, " +
                "keep the knees locked throughout. Keep your headposition neutral and stand up straight. Point your toes.", R.raw.front_scale));
        mWorkouts.add(new Workout("Ido Squat", true, true, false,
                false, 1, 1, 1, 5, 0 ,"Put something under your heels if you cannot sit in a squat " +
                "yet, but do not raise your heels any further. Move on to the floor eventually.", R.raw.ido_squat_routine));
        mWorkouts.add(new Workout("Hip Flexor Stretch", true, true, false, false,
                2, 1, 1,1, 0,"Relax",  R.raw.hip_flexor_stretch ));

    }

    public static PhaseTwoWorkout get(Context context){
        if (sPhaseOneWorkout == null){
            sPhaseOneWorkout = new PhaseTwoWorkout(context);
        }
        return sPhaseOneWorkout;
    }

    public List<Workout> getWorkouts() {
        return mWorkouts;
    }

    public Workout getWorkout(UUID uuid){
        for (Workout workout: mWorkouts){
            if (workout.getUUID().equals(uuid)){
                return workout;
            }
        }
        return null;
    }

}
