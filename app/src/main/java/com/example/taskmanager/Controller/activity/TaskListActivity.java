package com.example.taskmanager.Controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.taskmanager.Controller.fragment.TaskListFragment;
import com.example.taskmanager.R;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container1);


            TaskListFragment taskListFragment = new TaskListFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container1,taskListFragment)
                    .commit();

    }


}