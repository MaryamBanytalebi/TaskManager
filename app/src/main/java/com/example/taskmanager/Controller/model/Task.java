package com.example.taskmanager.Controller.model;

public class Task {
    private String mName,mState;

    public Task() {
    }

    public String getName() {
        return mName;
    }

    public String getState() {
        return mState;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setState(String state) {
        mState = state;
    }
}
