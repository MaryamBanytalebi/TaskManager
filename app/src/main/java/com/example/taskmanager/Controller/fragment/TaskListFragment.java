package com.example.taskmanager.Controller.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.taskmanager.Controller.model.Task;
import com.example.taskmanager.Controller.repository.Repository;
import com.example.taskmanager.R;

import java.util.List;

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
        findViews(view);
        initViews();
        return view;
    }

    private void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Repository repository = Repository.getInstance();
        List<Task> tasks = repository.getTasks();

        TaskAdapter taskAdapter = new TaskAdapter(tasks);
        mRecyclerView.setAdapter(taskAdapter);
    }

    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerViewTaskList);
    }
    private class TaskHolder extends RecyclerView.ViewHolder{
        private TextView mTextViewName;
        private TextView mTextViewState;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewName = itemView.findViewById(R.id.txt_name);
            mTextViewState = itemView.findViewById(R.id.txt_state);

        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder>{
        private List<Task> mTasks;

        public List<Task> getTasks() {
            return mTasks;
        }

        public void setTasks(List<Task> tasks) {
            mTasks = tasks;
        }

        public TaskAdapter(List<Task> tasks) {
            mTasks = tasks;
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutinflater= LayoutInflater.from(getActivity());
            View view = layoutinflater.inflate(R.layout.task_row_list,parent,false);

            TaskHolder taskHolder = new TaskHolder(view);
            return taskHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            Task task = mTasks.get(position);
            holder.mTextViewName.setText(task.getName());
            holder.mTextViewState.setText(task.getState());

        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }

}