package com.example.basicapp;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

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

        Log.e("TAG",edtUsername.getText().toString());

        edtUsername.setText("This is email");

        Log.e("TAG",edtUsername.getText().toString());

//         btnLogin.setOnClickListener(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Editable editable = edtUsername.getText();
                String str = editable.toString();
                str.isEmpty(); */

               if (edtUsername.getText().toString().isEmpty()){
                   Toast.makeText(LoginActivity.this, "Please enter your username", Toast.LENGTH_SHORT).show();

               }else if(edtPassword.getText().toString().isEmpty()){
                   edtPassword.setError("Please enter your password");

               }else{

               }

            }
        });


    }

    @Override
    public void onClick(View view) {
      /* switch (view.getId()){
           case R.id.btn_login:
               break;
       }*/

    }
}
