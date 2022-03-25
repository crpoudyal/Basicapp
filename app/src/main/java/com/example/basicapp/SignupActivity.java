package com.example.basicapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    public static final String EMAIL = "int_email";
    public static final String PASSWORD = "int_password";



    EditText edtEmail;
    EditText edtPass;
    EditText edtAddress;
    EditText edtPhNumber;
    EditText edtBio;
    Button signupButton;
    RadioGroup rgGender;
    RadioButton rbMale,rbFemale,rbOther;
    Spinner spStates;

    String[] states = {"state1","state2","state3","state4","state5","state6","state7"};
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
        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.male);
        rbFemale = findViewById(R.id.female);
        rbOther = findViewById(R.id.other);
        spStates = findViewById(R.id.sp_states);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,states);

        spStates.setAdapter(arrayAdapter);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //setOnCheckedChangeListener works same for checkbox as well

        rbMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });



        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (rgGender.getCheckedRadioButtonId()){
                    case R.id.male:
                        Log.i("TAG","Male selected");
                        break;
                    case R.id.female:
                        Log.i("TAG","Female selected");
                        break;
                    case R.id.other:
                        Log.i("TAG","Other selected");
                        break;
                    default:
                        Log.i("TAG","Nothing selected");
                        break;
                }





                 String email = edtEmail.getText().toString();
                 String password = edtPass.getText().toString();
                 String address = edtAddress.getText().toString();
                 String bio = edtBio.getText().toString();

               Boolean chk = validation(email,password,address,bio);

               if(chk){
                   Toast.makeText(SignupActivity.this, "Signup success", Toast.LENGTH_SHORT).show();

                   Intent intent = new Intent(SignupActivity.this,LoginActivity.class);

                   intent.putExtra(EMAIL,email);
                   Log.e("TAG",email);

                   intent.putExtra(PASSWORD,password);
                   Log.e("TAG",password);

                   startActivity(intent);
                   finish();
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
