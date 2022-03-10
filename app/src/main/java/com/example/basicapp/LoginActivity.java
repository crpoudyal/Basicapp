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

       if(chk == true){
           Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
           startActivity(intent);
           finish();

       }else{
           Toast.makeText(LoginActivity.this, "Fill all information", Toast.LENGTH_SHORT).show();

       }
    }

    private boolean loginValidation(String username, String password) {

        if (username.isEmpty()) {
            edtUsername.setError("Username should have something");
            return false;
        }
        else if (username.length() < 6) {
            edtUsername.setError("Username should be of 6 character or more");
            return false;
        }
        if (password.isEmpty()) {
            edtPassword.setError("Please enter your password");
            return false;
        } else if (password.length() < 10) {
            edtPassword.setError("Password must be 10 character or more");
            return false;
        } else {
            return true;
        }
    }
}



