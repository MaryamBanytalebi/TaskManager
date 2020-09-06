package com.example.taskmanager.Controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.taskmanager.Controller.fragment.InputTaskFragment;
import com.example.taskmanager.R;

public class InputTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_task);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container1);

        if (fragment == null){
            InputTaskFragment inputTaskFragment = new InputTaskFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container1,inputTaskFragment)
                    .commit();
        }
    }
}