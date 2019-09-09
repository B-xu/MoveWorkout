package com.example.moveworkout;

import androidx.annotation.RawRes;

import java.util.UUID;

public class Workout {
    private String mName;
    private boolean mIsTimed;
    private boolean mHasVideo;
    private boolean mHasProgression;
    private boolean mIsHeader;
    private int     mReps;
    private int     mSets;
    private int     mRests;
    private int    mRestMinutes;
    private int    mRestSeconds;
    private String  mCues;
    private UUID mUUID;
    private int mResource;

    public Workout(String name, boolean isTimed, boolean hasVideo, boolean hasProgression, boolean isHeader,
                   int reps, int sets, int rests, int restMinutes, int restSeconds, String cues, int resource) {
        mName = name;
        mIsTimed = isTimed;
        mHasVideo = hasVideo;
        mHasProgression = hasProgression;
        mIsHeader = isHeader;
        mReps = reps;
        mSets = sets;
        mRests = rests;
        mRestMinutes = restMinutes;
        mRestSeconds = restSeconds;
        mCues = cues;
        mUUID = UUID.randomUUID();
        mResource = resource;
    }

    public String getName() {
        return mName;
    }

    public boolean isTimed() {
        return mIsTimed;
    }


    public boolean hasVideo() {
        return mHasVideo;
    }

    public boolean isHeader() {
        return mIsHeader;
    }

    public boolean isHasProgression() {
        return mHasProgression;
    }


    public int getReps() {
        return mReps;
    }

    public void setReps(int reps) {
        mReps = reps;
    }

    public int getSets() {
        return mSets;
    }

    public int getRests() {
        return mRests;
    }


    public int getRestMinutes() {
        return mRestMinutes;
    }

    public int getRestSeconds() {
        return mRestSeconds;
    }

    public String getCues() {
        return mCues;
    }


    public UUID getUUID() {
        return mUUID;
    }

    public int getResource() {
        return mResource;
    }

}
