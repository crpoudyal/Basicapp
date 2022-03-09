package com.example.basicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    EditText edtEmail;
    EditText edtPass;
    EditText edtAddress;
    EditText edtPhNumber;
    EditText edtBio;
    Button signupButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_form);
        edtEmail = findViewById(R.id.edt_email);
        edtPass = findViewById(R.id.edt_pass);
        edtAddress = findViewById(R.id.edt_address);
        edtPhNumber = findViewById(R.id.edt_ph_number);
        edtBio = findViewById(R.id.edt_bio);
        signupButton = findViewById(R.id.signup_btn);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String email = edtEmail.getText().toString();
                 String password = edtPass.getText().toString();
                 String address = edtAddress.getText().toString();
                 String bio = edtBio.getText().toString();

               Boolean chk = validation(email,password,address,bio);

               if(chk == true){
                   Toast.makeText(SignupActivity.this, "Signup success", Toast.LENGTH_SHORT).show();

                   Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                   startActivity(intent);
                   
               }else{
                   Toast.makeText(SignupActivity.this, "Fill all the information", Toast.LENGTH_SHORT).show();
               }

            }
        });

    }

    private Boolean validation(String email, String password, String address, String bio) {
        if(email.isEmpty()){
            edtEmail.requestFocus();
            edtEmail.setError("Please enter your email");
            return false;
        }
        else if(!email.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")){
            edtEmail.requestFocus();
            edtEmail.setError("valid email format xyz@xyz.com");
            return false;
        }
         if(password.isEmpty()){
             edtPass.requestFocus();
             edtPass.setError("Please enter your password");
             return false;

         }else if(password.length() < 10){
             edtPass.requestFocus();
             edtPass.setError("Password must be 10 character or more");
             return false;
         }
         if(address.isEmpty()){
             edtAddress.requestFocus();
             edtAddress.setError("Please enter your address");
             return false;
         }
         if(bio.isEmpty()){
             edtAddress.requestFocus();
             edtBio.setError("Please enter your bio");
             return false;
         }else {
             return  true;
         }
    }
}
