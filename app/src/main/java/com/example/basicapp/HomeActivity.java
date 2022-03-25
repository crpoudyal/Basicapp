package com.example.basicapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {
    String email;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

       Intent i = getIntent();
       email = i.getStringExtra(LoginActivity.EMAIL);

       TextView txt = findViewById(R.id.res_email);
       txt.setText(email);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case 100:
                    if(data.hasExtra("EMAIL")){
                        data.getStringExtra("EMAIL");
                    }
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
