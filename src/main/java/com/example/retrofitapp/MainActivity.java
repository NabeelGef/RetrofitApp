package com.example.retrofitapp;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitapp.R;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParsePlugins;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button Login,Sign,List;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = findViewById(R.id.login_in);
        Sign = findViewById(R.id.sign_up);
        List = findViewById(R.id.ListEmployee);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login_in.class);
                startActivity(intent);
            }
        });
        Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Sign_up.class);
                startActivity(intent);
            }
        });
        List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListEmployee.class);
                startActivity(intent);
            }
        });
    }
}
