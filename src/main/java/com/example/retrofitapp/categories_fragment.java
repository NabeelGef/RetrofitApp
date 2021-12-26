package com.example.retrofitapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link categories_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class categories_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_Id = "ID";
    private static final String ARG_name = "name";

    // TODO: Rename and change types of parameters
    private int Id;
    private String name;
    private Boolean aBoolean = false;
   public  void setaBoolean(boolean b , View view){
       this.aBoolean = b;
       System.out.println("Boolean1 = " + aBoolean);

   }
    public categories_fragment() {
        // Required empty public constructor
    }

  // TODO: Rename and change types and number of parameters
    public static categories_fragment newInstance(int param1, String param2) {
        categories_fragment fragment = new categories_fragment();
        Bundle args = new Bundle();
        args.putInt(ARG_Id, param1);
        args.putString(ARG_name, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Id = getArguments().getInt(ARG_Id);
            name = getArguments().getString(ARG_name);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView1 = view.findViewById(R.id.text1);
        TextView textView2 = view.findViewById(R.id.text2);
        Button button = view.findViewById(R.id.Click_Main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireActivity().getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        textView1.setText("ID = " + Id);
        textView2.setText("Name = " + name);
    }
}