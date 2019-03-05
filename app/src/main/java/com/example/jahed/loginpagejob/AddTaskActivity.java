package com.example.jahed.loginpagejob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener {


    EditText taskEt;
    Button saveTaskBtn;
    UserTaskDataManager userTaskDataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);


        taskEt=findViewById(R.id.addTaskEt);
        saveTaskBtn=findViewById(R.id.saveTaskBtn);

        userTaskDataManager=new UserTaskDataManager(this);
        saveTaskBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        if(taskEt.getText().toString().isEmpty()){
            taskEt.setHint("Empty is not allow");

        }else {

            userTaskDataManager.addUserTask(new UserTask(taskEt.getText().toString()));
            Intent intent=new Intent(this,UserTaskActivity.class);
            startActivity(intent);

        }


    }







}
