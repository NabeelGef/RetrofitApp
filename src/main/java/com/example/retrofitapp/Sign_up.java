package com.example.retrofitapp;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseSession;
import com.parse.SaveCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sign_up extends AppCompatActivity {
    EditText name, password, email, numberTel;
    Button Sign;
    ProgressBar progressBar;
    Bundle bundle;
    Data data ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        numberTel = findViewById(R.id.numberTel);
        bundle = new Bundle();
        progressBar = findViewById(R.id.prog);
        Sign = findViewById(R.id.sign_up);
        Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    private void signup() {
        progressBar.setVisibility(View.VISIBLE);
        final String Name  = name.getText().toString();
        final String Email = email.getText().toString();
        final String Password = password.getText().toString();
        final String NumberTel = numberTel.getText().toString();
         data = new Data(Name , Email , Password , NumberTel);
         Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        API api = retrofit.create(API.class);
        Call <ResponseBody> call = api.postAllData(data);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String state = response.body().string();
                    System.out.println("State = " + state);
                    if (!state.isEmpty()) {
                        Toast.makeText(getApplicationContext(),state, Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    } else {
                        System.out.println("Stat2 = " + state);
                    Toast.makeText(getApplicationContext(), "Success signning", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    bundle.putString("Email", Email);
                    bundle.putString("Password", Password);
                    Intent intent = new Intent(getApplicationContext(), Your_profile.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                } catch (IOException e) {
                    progressBar.setVisibility(View.GONE);
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
               progressBar.setVisibility(View.GONE);
               Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                System.out.println("error = " + t.getMessage());
            }
        });
    }
}
