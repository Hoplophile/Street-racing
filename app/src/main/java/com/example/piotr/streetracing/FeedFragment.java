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
    public String[] times ={"today 12:45", "today 13:54 ","today 14:20",  "today 14:25",   "today 16:01", "today 16:44", "today 17:43", "today 20:56","today 22:30","today 23:32"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View android = inflater.inflate(R.layout.fragment_feed, container, false);
        scroll = (ScrollView) android.findViewById(R.id.scroll);
        scrollLin = (LinearLayout) android.findViewById(R.id.scrollLin);

        for (int i = 0; i < 10 ; i++) {
            FeedCell feed_cell = new FeedCell(getActivity(), names[i], times[9-i]);
            scrollLin.addView(feed_cell);
        }


        return android;
    }
}