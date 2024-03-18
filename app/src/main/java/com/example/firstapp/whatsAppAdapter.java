package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class whatsAppAdapter extends FragmentPagerAdapter {
    public whatsAppAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new Chats();
        }
        else if(position==1){
            return new Updates();
        }
        else{
            return new Calls();
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0) return "Chats";
        else if (position==1) return "Updates";
        else return "Calls";
    }
}
