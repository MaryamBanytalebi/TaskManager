package com.example.taskmanager.Controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskmanager.R;
public class TaskListFragment extends Fragment {
    private String mNameUser;
    private int mCountUser;
    private RecyclerView mRecyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   public TaskListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
   /* public static TaskListFragment newInstance(String param1, String param2) {
        TaskListFragment fragment = new TaskListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNameUser = getActivity().getIntent().getStringExtra(InputTaskFragment.EXTRA_NAME);
        mCountUser = getActivity().getIntent().getIntExtra(InputTaskFragment.EXTRA_COUNT,0);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        mRecyclerView = findViews(view);
        return view;
    }

    private RecyclerView findViews(View view) {
        return view.findViewById(R.id.recyclerViewTaskList);
    }
}