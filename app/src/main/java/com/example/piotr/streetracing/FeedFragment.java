package com.example.piotr.streetracing;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class FeedFragment extends Fragment {
    ScrollView scroll;
    LinearLayout scrollLin;

    public String[] names ={"Alonzo", "Tresa ","Huey",  "Roseanne",   "Margarite", "Pete", "Alene", "Kayleigh","Danita","Hee"};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View android = inflater.inflate(R.layout.fragment_feed, container, false);
        scroll = (ScrollView) android.findViewById(R.id.scroll);
        scrollLin = (LinearLayout) android.findViewById(R.id.scrollLin);

        for (int i = 0; i < 10 ; i++) {
            Cell cell = new Cell(getActivity(), names[i]);
            scrollLin.addView(cell);
        }


        return android;
    }
}