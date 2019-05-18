package com.example.dhani.kholas.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dhani.kholas.fragmen.Surat;
import com.example.dhani.kholas.fragmen.Juz;
import com.example.dhani.kholas.fragmen.Bookmark;

public class TabFragmentPagerAdapter extends FragmentPagerAdapter{
    String[] title = new String[]{
            "Surat", "Juz", "Bookmark"
    };

    public TabFragmentPagerAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Surat();
                break;
            case 1:
                fragment = new Juz();
                break;
            case 2:
                fragment = new Bookmark();
                break;
            default:
                fragment = null;
                break;
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return title.length;
    }


}
