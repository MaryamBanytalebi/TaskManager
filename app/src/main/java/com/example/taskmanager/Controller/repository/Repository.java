package com.example.taskmanager.Controller.repository;

import com.example.taskmanager.Controller.State;
import com.example.taskmanager.Controller.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Repository {
    private static Repository sInstance;
    private static String mName;
    private static int mCount;

    public static Repository getInstance() {
        if (sInstance == null)
            sInstance = new Repository();

        return sInstance;
    }

    private List<Task> mTasks;

    private Repository() {
        mTasks = new ArrayList<>();
        for (int i = 0; i < mCount ; i++) {
            Task task =new Task(mName,randomState());
            mTasks.add(task);
           /* task.setName(mName);
            task.setState(randomState());*/
        }
    }

    public State randomState(){
        int pick = new Random().nextInt(State.values().length);
        return State.values()[pick];
    }

    public static void setName(String mName) {
        Repository.mName = mName;
    }

    public static void setCount(int mCount) {
        Repository.mCount = mCount;
    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setTasks(List<Task> tasks) {
        mTasks = tasks;
    }

    public void addTasks(Task task){
        mTasks.add(task);
    }

}
