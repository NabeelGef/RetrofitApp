package com.example.retrofitapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Adapter_Fragment extends FragmentStatePagerAdapter {
    ArrayList<MyTap> myTaps = new ArrayList<>();

    public Adapter_Fragment(@NonNull FragmentManager fm) {
        super(fm);
    }
    public void addTabs(MyTap myTap){
        myTaps.add(myTap);
   }
    @Override
    public int getCount() {
        return myTaps.size();
    }
    @NonNull
    @Override
    public CharSequence getPageTitle(int position)
    {
        return myTaps.get(position).getName();
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return myTaps.get(position).getFragment();
    }
}
