package com.example.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_in extends AppCompatActivity {
    EditText editText1 , editText2;
    Button Login;
    URL url;
    boolean f= false;
    ParseQuery <ParseObject> query;
    ProgressBar progressBar;
    Bundle bundle;
    Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
        editText1 = findViewById(R.id.emailL);
        editText2 = findViewById(R.id.passwordL);
        bundle = new Bundle();
        Login = findViewById(R.id.loginL);
        progressBar = findViewById(R.id.prog);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_in();
            }
        });
    }

    private void login_in() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        API api = retrofit.create(API.class);
        Call<Data> call = api.getyourProfile(editText1.getText().toString(),
                editText2.getText().toString());
        call.enqueue(new Callback <Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                bundle.putString("Email",editText1.getText().toString());
                bundle.putString("Password",editText2.getText().toString());
                System.out.println("NumberTel = " + response.body().getNumberTel()) ;
                Intent intent = new Intent(getApplicationContext(),Your_profile.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                System.out.println("Error = " + t.getMessage());
            }
        });
    }

}