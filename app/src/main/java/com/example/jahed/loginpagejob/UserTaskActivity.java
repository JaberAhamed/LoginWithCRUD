package com.example.jahed.loginpagejob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserTaskActivity extends AppCompatActivity implements View.OnClickListener {



    Button taskBtn;
    ListView taskLV;

    TaskAdapter taskAdapter;
    UserTaskDataManager userTaskDataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_task);


        userTaskDataManager=new UserTaskDataManager(this);
        taskLV=findViewById(R.id.taskLV);
        taskBtn =findViewById(R.id.addTaskBtn);
        taskBtn.setOnClickListener(this);

        final ArrayList<UserTask>userTasks=userTaskDataManager.getUserTask();



            taskAdapter = new TaskAdapter(this,userTasks);
            taskLV.setAdapter(taskAdapter);





        taskLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(UserTaskActivity.this, userTasks.get(position).getUsertask(), Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getApplicationContext(),TaskUpdateActivity.class);
                intent.putExtra("task",userTasks.get(position).getUsertask());
                intent.putExtra("id",String.valueOf(userTasks.get(position).getUserTaskId()));
                startActivity(intent);

            }
        });






    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent(this,AddTaskActivity.class);
        startActivity(intent);



    }
}
