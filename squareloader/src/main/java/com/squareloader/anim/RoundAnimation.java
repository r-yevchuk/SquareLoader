package com.squareloader.anim;

import android.widget.ImageView;
import com.squareloader.Config;

public class RoundAnimation extends SpiralAnimation{

    public RoundAnimation(ImageView[] ivs, Config config) {
        super(ivs, config);
        ivs[4].setBackgroundColor(config.getSecondaryColor());
        path = new int[]{0, 1, 2, 5, 8, 7, 6, 3};
    }
}
