package com.example.jahed.loginpagejob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email_Edt,pasword_Edt;
    TextView signupLink_Tv;
    Button loginBtn;
    UserInfoLogInDataManage userInfoLogInDataManage;
    ArrayList<UserLoginfo>userLoginfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email_Edt=findViewById(R.id.emai_Edt);
        pasword_Edt=findViewById(R.id.password_Edt);

        loginBtn = findViewById(R.id.loginBtn);

        signupLink_Tv=findViewById(R.id.linkSignUp);

        userInfoLogInDataManage =new UserInfoLogInDataManage(this);




        loginBtn.setOnClickListener(this);
        signupLink_Tv.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.loginBtn:{
                login();

                break;
            }
            case R.id.linkSignUp:{

                SignUp();

                  break;
            }

        }

    }

    private void login() {

    String email=email_Edt.getText().toString();
    String password=pasword_Edt.getText().toString();
        userLoginfo= userInfoLogInDataManage.getUserLogInfo();

        Toast.makeText(this, String.valueOf(userLoginfo.size()), Toast.LENGTH_SHORT).show();

        if (email.isEmpty()||password.isEmpty()){

            Toast.makeText(this, "Unvalide email and password", Toast.LENGTH_SHORT).show();

        }
        else {

             for (int i=0;i<userLoginfo.size();i++){


                 if (email.equals(userLoginfo.get(i).getUserEmail())&&password.equals(userLoginfo.get(i).getUserPassword())){

                     Intent intent=new Intent(this,UserTaskActivity.class);
                     startActivity(intent);
                     finish();



                 }




             }


        }



    }

    private void SignUp() {

        Intent intent=new Intent(this,SignUpActivity.class);
        startActivity(intent);

    }
}
