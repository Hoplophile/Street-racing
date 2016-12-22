package com.example.piotr.streetracing;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by piotr on 22.12.2016.
 */

public class SegmentCell extends LinearLayout {
    private TextView segmentName, bestTime, segmentLength;

    public SegmentCell(Context context, String length, String name, String best_time) {

        super(context);
        View.inflate(context, R.layout.segment_cell, this);

        segmentName = (TextView) findViewById(R.id.segment_name);
        bestTime = (TextView) findViewById(R.id.best_time);
        segmentLength = (TextView) findViewById(R.id.length);

        segmentName.setText(name);
        bestTime.setText(best_time);
        segmentLength.setText(length);
    }
}