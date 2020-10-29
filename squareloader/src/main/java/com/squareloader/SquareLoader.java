package com.squareloader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.*;
import java.util.*;

public class SquareLoader extends LinearLayout {
    private final Context context;
    private ImageView[] ivs = new ImageView[9];
//    private int[] path = { 0, 1, 2, 5, 4, 3, 6, 7, 8, 5, 4, 3 };
    private int[] path = { 0, 1, 2, 5, 8, 7, 6, 3, 4 };
    private int items = 0;
    private int count = 0;

    private int primaryColor = Color.GREEN;
    private int secondaryColor = Color.GRAY;
    private int currentColor;
    private int pass;

    public SquareLoader(Context context) {
        super(context);
        this.context = context;
        setLayoutParams(new RelativeLayout.LayoutParams(dpToPx(92), dpToPx(92)));
        setOrientation(LinearLayout.VERTICAL);

        setBackgroundColor(Color.LTGRAY);

        init();
    }

    private static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    private void init() {
        RelativeLayout.LayoutParams rowParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(24));
        rowParams.setMargins(0, dpToPx(5), 0, 0);
        int tag = 0;

        for (int i = 0; i < 3; i++) {
            LinearLayout ll = new LinearLayout(context);
            ll.setLayoutParams(rowParams);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            for (int j = 0; j < 3; j++) {
                ivs[tag] = new ImageView(context);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(dpToPx(24), dpToPx(24));
                params.setMargins(dpToPx(5), 0, 0, 0);
                ivs[tag].setLayoutParams(params);
                ivs[tag].setBackgroundColor(Color.GREEN);
                ll.addView(ivs[tag]);
                tag++;
            }
            this.addView(ll);
        }
    }

    private void reset() {
        for (ImageView iv: ivs){
            iv.setBackgroundColor(Color.GREEN);
        }
    }

    public void start() {
        currentColor = secondaryColor;
        pass = 1;
        if (!Arrays.asList(ivs).contains(null)){
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (pass > 2){
                        currentColor = secondaryColor;
                        pass = 1;
                        count = 0;
                    }
                    if (count > path.length - 1){
                        count = 0;
                        pass++;
                        currentColor = primaryColor;
                    }
                    items = path[count++];
                    ivs[items].setBackgroundColor(currentColor);
                }
            }, 0, 250);

        }
    }



}
