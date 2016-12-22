package com.example.piotr.streetracing;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Szymon on 18.12.2016.
 */

public class FeedCell extends LinearLayout {
    TextView tvName, date;

    public FeedCell(Context context, String name, String time) {

        super(context);
        View.inflate(context, R.layout.feed_cell, this);

        tvName = (TextView) findViewById(R.id.username);
        date = (TextView) findViewById(R.id.date);

        tvName.setText(name);
        date.setText(time);
        Typeface boldTf = Typeface.createFromAsset(context.getAssets(), "fonts/sbold.ttf");
        Typeface regularTf = Typeface.createFromAsset(context.getAssets(), "fonts/regular.ttf");
        tvName.setTypeface(boldTf);
        date.setTypeface(regularTf);

    }
}
