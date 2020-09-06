package com.example.taskmanager.Controller.repository;

import com.example.taskmanager.Controller.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static Repository sInstance;

    public static Repository getInstance() {
        if (sInstance == null)
            sInstance = new Repository();

        return sInstance;
    }

    private List<Task> mTasks;

    private Repository() {
        mTasks = new ArrayList<>();
        for (int i = 0; i < mTasks.size() ; i++) {
            Task task =new Task();
            task.setName(task.getName());
            task.setState(task.getState());

        }

    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setTasks(List<Task> tasks) {
        mTasks = tasks;
    }
}
