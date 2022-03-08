package com.example.basicapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        edtPass =findViewById(R.id.edt_pass);
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

               validation(email,password,address,bio);

            }
        });

    }

    private void validation(String email, String password, String address, String bio) {
        if(email.isEmpty()){
            edtEmail.setError("Please enter your email");

        }
        else if(password.isEmpty()){
           edtPass.setError("Please enter your password");
        }
        else if(address.isEmpty()){
            edtAddress.setError("Please enter your address");

        }
        else if(bio.isEmpty()){
            edtBio.setError("Please enter your bio");

        }
    }
}
