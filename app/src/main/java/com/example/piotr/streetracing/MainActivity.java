package com.example.piotr.streetracing;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    MainFragmentPagerAdapter pagerAdapter;
    LinearLayout linearTab;

    private int[] imageResId = {
            R.drawable.menuselector_record,
            R.drawable.menuselector_feed,
            R.drawable.menuselector_feed,
            R.drawable.menuselector_feed,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        checkPermissions();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        linearTab = (LinearLayout) findViewById(R.id.linearTab);
        pagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(pagerAdapter);

        // Give the TabLayout the ViewPager
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(imageResId[i]);
        }

        /*for (int k = 0; k < tabLayout.getTabCount(); k++) {
            TabLayout.Tab tab1 = tabLayout.getTabAt(k);
            tab1.setCustomView(pagerAdapter.getTabViewGrey(k, MainActivity.this));
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);

                int i = tab.getPosition();
                tab = tabLayout.getTabAt(i);
                Log.d("SJ", "zaznaczono"+i);
                //tab.setCustomView(pagerAdapter.getTabView(i));

                for (int k = 0; k < tabLayout.getTabCount(); k++) {
                    TabLayout.Tab tab1 = tabLayout.getTabAt(k);
                    tab1.setCustomView(pagerAdapter.getTabView(k));
                }

            }

        });*/

    }
    private void checkPermissions(){
        checkAccessNetworkStatePermission();
        checkInternetPermission();
        checkAccessCoarseLocationPermission();
        checkAccessFineLocationPermission();
    }
    private void checkAccessNetworkStatePermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_NETWORK_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_NETWORK_STATE)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, 1);
            }
        }
    }

    private void checkInternetPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.INTERNET)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 2);
            }
        }
    }

    private void checkAccessCoarseLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 3);
            }
        }
    }

    private void checkAccessFineLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 4);
            }
        }
    }
}