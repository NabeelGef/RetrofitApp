package com.example.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Options extends AppCompatActivity {
 ViewPager viewPager;
 TabLayout tabLayout;
 Adapter_Fragment adapter ;
 categories_fragment cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        cat = new categories_fragment();
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.Tap);
        adapter = new Adapter_Fragment(getSupportFragmentManager());
        adapter.addTabs(new MyTap("Food",categories_fragment.newInstance(1,"chicken")));
        adapter.addTabs(new MyTap("Drinking",categories_fragment.newInstance(2,"Juice")));
        adapter.addTabs(new MyTap("Dessert",categories_fragment.newInstance(3,"Cake")));
        adapter.addTabs(new MyTap("Other",categories_fragment.newInstance(4,"other")));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}