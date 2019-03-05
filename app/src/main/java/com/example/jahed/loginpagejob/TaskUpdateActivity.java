package com.example.jahed.loginpagejob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TaskUpdateActivity extends AppCompatActivity implements View.OnClickListener {


    EditText taskUpdate;
    Button updateTask,deleteTask;
    String task,id;
    UserTaskDataManager userTaskDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_update);


        taskUpdate=findViewById(R.id.taskUpdate);
        updateTask=findViewById(R.id.updateTasBtn);
        deleteTask=findViewById(R.id.deleteTask);

        Intent intent = getIntent();
        task=intent.getStringExtra("task");
        id=intent.getStringExtra("id");

        taskUpdate.setText(task);
        updateTask.setOnClickListener(this);
        deleteTask.setOnClickListener(this);

        userTaskDataManager=new UserTaskDataManager(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.updateTasBtn:{

             userTaskDataManager.updateTask(new UserTask(Integer.valueOf(id),taskUpdate.getText().toString()));
                Intent intent=new Intent(getApplicationContext(),UserTaskActivity.class);
                startActivity(intent);
                finish();



                break;
            }
            case R.id.deleteTask:{

                userTaskDataManager.deleteTask(Integer.valueOf(id));

                Intent intent=new Intent(getApplicationContext(),UserTaskActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }



    }
}
