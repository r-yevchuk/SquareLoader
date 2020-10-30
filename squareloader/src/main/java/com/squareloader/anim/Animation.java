package com.squareloader.anim;

import android.widget.ImageView;

public abstract class Animation {
    protected ImageView[] ivs;

    Animation(ImageView[] ivs) {
        this.ivs = ivs;
    }

    abstract public void start();
}
