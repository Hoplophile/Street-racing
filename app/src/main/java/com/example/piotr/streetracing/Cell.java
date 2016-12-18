package com.example.piotr.streetracing;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Szymon on 18.12.2016.
 */

public class Cell extends LinearLayout {
    TextView tvName, date;
    public Cell(Context context, String name) {

        super(context);
        View.inflate(context, R.layout.cell, this);

        tvName = (TextView) findViewById(R.id.username);
        date = (TextView) findViewById(R.id.date);

        tvName.setText(name);
        Typeface boldTf = Typeface.createFromAsset(context.getAssets(), "fonts/sbold.ttf");
        Typeface regularTf = Typeface.createFromAsset(context.getAssets(), "fonts/regular.ttf");
        tvName.setTypeface(boldTf);
        date.setTypeface(regularTf);

    }
}
