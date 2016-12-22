package com.example.piotr.streetracing;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;


public class SegmentsFragment extends Fragment {
    ScrollView scrollSeg;
    LinearLayout scrollLinSeg;
    String[] names = {"Apeczkowa Trasa", "Aleje", "Wokół AGH", "Janik - Filip", "Brono - NH","Nie mam pomysłu"};
    String[] best_times = {"15:43:10", "01:52:13", "2:24:01", "12:14:16", "22:18:11", "00:16:13"};
    String[] lengths = {"12 km", "8 km", "3.5 km", "10 km", "21km", "0.32 km"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View android = inflater.inflate(R.layout.fragment_segments, container, false);

        scrollSeg = (ScrollView) android.findViewById(R.id.scrollSeg);
        scrollLinSeg = (LinearLayout) android.findViewById(R.id.scrollLinSeg);


        for (int i = 0; i < 6 ; i++) {
            SegmentCell segmentCell = new SegmentCell(getActivity(), "Length: ".concat(lengths[i]),
                    names[i], "Best time: ".concat(best_times[i]));
            scrollLinSeg.addView(segmentCell);
        }


        return android;
    }
}
