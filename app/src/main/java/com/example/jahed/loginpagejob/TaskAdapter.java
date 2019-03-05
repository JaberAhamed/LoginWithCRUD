package com.example.jahed.loginpagejob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Trainer on 8/22/2017.
 */

public class TaskAdapter extends ArrayAdapter<UserTask> {

    private Context context;
    private ArrayList<UserTask>languageList;

    public TaskAdapter(Context context, ArrayList<UserTask> userTasks) {
        super(context, R.layout.single_row, userTasks);
        this.context = context;
        this.languageList = userTasks;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.single_row,parent,false);

        TextView langNameTV = convertView.findViewById(R.id.task);


        langNameTV.setText(languageList.get(position).getUsertask());



        return convertView;
    }
}
