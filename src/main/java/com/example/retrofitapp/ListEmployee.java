package com.example.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListEmployee extends AppCompatActivity {
  RecyclerView recyclerView ;
  Adapter adapter;
  ArrayList<Data> data ;
  ArrayList<Data> data2;
  ArrayList<Integer>indexes;
  SearchView searchView;
  boolean found;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employee);
        recyclerView = findViewById(R.id.recycleList);
        searchView = findViewById(R.id.Search);
        adapter = new Adapter();
        indexes = new ArrayList<>();
        data2 = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        API api = retrofit.create(API.class);
        Call<ArrayList<Data>> call = api.getAllData();
        call.enqueue(new Callback<ArrayList<Data>>() {
            @Override
            public void onResponse(Call<ArrayList<Data>> call, Response<ArrayList<Data>> response) {
                data = response.body();
                adapter.setList(data);
                showList();
            }

            @Override
            public void onFailure(Call<ArrayList<Data>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    adapter.setList(data);
                    data2.clear();
                } else {
                    for (int i = 0; i < data.size(); i++)
                        SearchByName(data.get(i).UserName, newText, i);
                    adapter.setList(data2);

                }
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
    private void Proccess(String userName, String newText, Integer integer) {
    if(userName.length()<newText.length()||!userName.substring(0,newText.length()).equals(newText)){
        indexes.remove(integer);
        clearFromData2(integer);
    }
    }
    private void clearFromData2(Integer integer) {
    data2.remove(data.get(integer));
    }
    private void SearchByName(String userName, String newText,int index) {
        if(newText.length()>userName.length()){
            clearFromData2(index);
        }
        else if(userName.substring(0,newText.length()).equals(newText)) {
         spillToData2(index);
        }
        else{
            clearFromData2(index);
        }
    }
    private void spillToData2(int i) {
        if(!data2.contains(data.get(i)))
            data2.add(data.get(i));
    }
    private void showList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapter);
    }
}