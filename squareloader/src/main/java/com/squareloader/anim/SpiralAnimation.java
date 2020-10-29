package com.squareloader.anim;

import android.widget.ImageView;
import com.squareloader.Config;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import static com.squareloader.Config.primaryColor;
import static com.squareloader.Config.secondaryColor;


public class SpiralAnimation extends Animation {
    private final int[] path = {0, 1, 2, 5, 8, 7, 6, 3, 4};
    private int count = 0;
    private int pass = 1;

    private int currentColor;

    public SpiralAnimation(ImageView[] ivs) {
        super(ivs);
    }

    @Override
    public void start() {
        currentColor = secondaryColor;
        if (!Arrays.asList(ivs).contains(null)) {
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (pass > 2) {
                        currentColor = secondaryColor;
                        pass = 1;
                        count = 0;
                    }
                    if (count > path.length - 1) {
                        count = 0;
                        pass++;
                        currentColor = primaryColor;
                    }
                    int id = path[count++];
                    ivs[id].setBackgroundColor(currentColor);
                }
            }, 0, Config.animationSpeed);
        }
    }
}
