package com.example.piotr.streetracing;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    final int PAGE_COUNT = 4;

    private int[] imageResId = {
            R.drawable.menuselector_feed,
            R.drawable.menuselector_record,
            R.drawable.menuselector_feed,
            R.drawable.menuselector_feed,

    };

    private int[] imageResIdActive = {
            R.drawable.feedactive,
            R.drawable.feedactive,
            R.drawable.feedactive,
            R.drawable.feedactive,
    };






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


  /*  public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(context).inflate(R.layout.tab, null);

        LinearLayout lin = (LinearLayout) v.findViewById(R.id.linearTab);
       //lin.removeViewAt(0);
        Log.d("SJ", ""+lin.getChildCount());
        ImageView img = new ImageView(context);


        img.setImageResource(imageResId[position]);
        lin.addView(img);
        return v;
    }
    public View getTabViewGrey(int position, Context context) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(context).inflate(R.layout.tab, null);


        LinearLayout lin = (LinearLayout) v.findViewById(R.id.linearTab);
       // lin.removeViewAt(0);
        ImageView img = new ImageView(context);


        img.setImageResource(imageResIdActive[position]);
        lin.addView(img);
        return v;
    }*/
}
