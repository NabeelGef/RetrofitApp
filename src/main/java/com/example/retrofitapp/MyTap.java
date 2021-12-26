package com.example.retrofitapp;

import androidx.fragment.app.Fragment;

public class MyTap {
    String Name ;
    Fragment fragment;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public MyTap(String name, Fragment fragment) {
        Name = name;
        this.fragment = fragment;
    }
}
