package com.example.taskmanager.Controller.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.taskmanager.Controller.fragment.InputTaskFragment;
import com.example.taskmanager.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment creatFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container1);

        if (fragment == null){
            //InputTaskFragment inputTaskFragment = new InputTaskFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container1,creatFragment())
                    .commit();
        }
    }
}
