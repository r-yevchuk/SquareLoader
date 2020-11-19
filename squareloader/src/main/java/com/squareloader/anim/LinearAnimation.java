package com.squareloader.anim;

import android.widget.ImageView;
import com.squareloader.Config;


public class LinearAnimation extends SpiralAnimation {

    public LinearAnimation(ImageView[] ivs, Config config) {
        super(ivs, config);
        path = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    }
}
