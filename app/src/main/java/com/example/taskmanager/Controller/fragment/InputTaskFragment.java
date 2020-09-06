package com.example.taskmanager.Controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.taskmanager.R;


public class InputTaskFragment extends Fragment {
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_COUNT = "count";
    public static final int REQUEST_CODE = 0;
    private EditText mEdtName,mEdtCount;
    private Button mBtnMake;

    public InputTaskFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    /*public static InputTaskFragment newInstance(String param1, String param2) {
        InputTaskFragment fragment = new InputTaskFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_task, container, false);
        findViews(view);
        setListeners();
        return view;
    }

    private void setListeners() {
        mBtnMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),TaskListFragment.class);
                intent.putExtra(EXTRA_NAME,mEdtName.getText().toString());
                intent.putExtra(EXTRA_COUNT,mEdtCount.getText().toString());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    private void findViews(View view) {
        mEdtName = view.findViewById(R.id.edt_name);
        mEdtCount = view.findViewById(R.id.edt_count);
        mBtnMake = view.findViewById(R.id.btn_make);
    }
}