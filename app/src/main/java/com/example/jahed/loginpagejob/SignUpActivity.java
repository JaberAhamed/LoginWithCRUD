package com.example.jahed.loginpagejob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email_Et,password_Et;
    Button signupBtn;
    UserInfoLogInDataManage userInfoLogInDataManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email_Et=findViewById(R.id.signup_Email_Edt);
        password_Et=findViewById(R.id.signup_Password_Edt);
        userInfoLogInDataManage = new UserInfoLogInDataManage(this);

        signupBtn=findViewById(R.id.signupBtn);

        signupBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {




       boolean isEmailValid= emailValidate(email_Et.getText().toString());
       boolean isPasswordValid=passwordValid(password_Et.getText().toString());


       if (isEmailValid==true&&isPasswordValid==true){

          long isSuccess= userInfoLogInDataManage.addUserLoginInfo(new UserLoginfo(email_Et.getText().toString(),password_Et.getText().toString()));

          if (isSuccess>0){

              Intent intent=new Intent(this,MainActivity.class);
              startActivity(intent);

          }


       }




    }

    private boolean passwordValid(String password) {

        if (password.isEmpty()){
            Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();

           return false;
        }
        else if(password.length()<6){

            Toast.makeText(this, "Password is too sort", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;




    }

    private boolean emailValidate(String email) {


        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.isEmpty()){

            email_Et.setText("Empty in not allow");
            return false;

        }
        else if (!email.matches(emailPattern)){
            email_Et.setText("Invalide email");
            return false;
        }






        return true;
    }
}
