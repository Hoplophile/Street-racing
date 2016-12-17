package com.example.piotr.streetracing;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    final int PAGE_COUNT = 4;




    public MainFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                MainFragment tab0 = new MainFragment();
                return tab0;
            case 1:
                FeedFragment tab1 = new FeedFragment();
                return tab1;
            case 2:
                SegmentsFragment tab2 = new SegmentsFragment();
                return tab2;
            case 3:
                SettingsFragment tab3 = new SettingsFragment();
                return tab3;
            default:
                return null;

        }


    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
