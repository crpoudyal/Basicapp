package com.example.basicapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    String email_str,password_str;

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);




        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);

//        Log.e("TAG",edtUsername.getText().toString());
//
//        edtUsername.setText("This is email");
//
//        Log.e("TAG",edtUsername.getText().toString());

        btnLogin.setOnClickListener(this);

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                /* Editable editable = edtUsername.getText();
//                String str = editable.toString();
//                str.isEmpty(); */
//                String username = edtUsername.getText().toString();
//                String password = edtPassword.getText().toString();
//
//
//              loginValidation(username,password);
//            }
//        });


    }

    @Override
    public void onClick(View view) {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();


       boolean chk= loginValidation(username, password);
        Intent i = getIntent();
        if (i.hasExtra(SignupActivity.EMAIL)) {
            email_str = i.getStringExtra(SignupActivity.EMAIL);
            Log.e("TAG",email_str);
        }
        if (i.hasExtra(SignupActivity.PASSWORD)) {
            password_str = i.getStringExtra(SignupActivity.PASSWORD);
            Log.e("TAG",password_str);
        }

       if(chk == true && username.equals(email_str) && password.equals(password_str)){
           Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(LoginActivity.this,HomeActivity.class);

           startActivity(intent);
           finish();

       }else{
           Toast.makeText(LoginActivity.this, "username and Password not match", Toast.LENGTH_SHORT).show();
       }
    }

    private boolean loginValidation(String username, String password) {

        if (username.isEmpty()) {
            edtUsername.setError("Username should have something");
            return false;
        }

        if (password.isEmpty()) {

            edtPassword.setError("Please enter your password");
            return false;
        }
            return true;

    }
}



