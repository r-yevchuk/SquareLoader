package com.squareloader.anim;

import android.widget.ImageView;
import com.squareloader.Config;

public abstract class Animation {
    protected ImageView[] ivs;
    protected final Config config;
    protected int[] path;

    Animation(ImageView[] ivs, Config config) {
        this.ivs = ivs;
        this.config = config;
    }

    abstract public void start();
}
