package com.example.taskmanager.Controller.model;

import com.example.taskmanager.Controller.State;

import java.util.Date;

public class Task {
    private String mName;
    private State mState;

    public Task(String name, State state) {
        mName = name;
        mState = state;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public State getState() {
        return mState;
    }

    public void setState(State state) {
        mState = state;
    }
}
