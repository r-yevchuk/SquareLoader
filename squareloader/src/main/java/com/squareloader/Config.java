package com.squareloader;

import android.graphics.Color;
import com.squareloader.utils.Size;
import com.squareloader.utils.Utils;

public class Config {
    public static int primaryColor = Color.GREEN;
    public static int secondaryColor = Color.GRAY;
    public static final int animationSpeed = 200;

    int squareSize;
    int squareMargin;

    public Config(){
        setSize(Size.NORMAL);
    }

    public void setSize(Size size){
        switch (size){
            case SMALL:
                squareSize = Utils.dpToPx(10);
                squareMargin = Utils.dpToPx(1);
                break;
            case NORMAL:
                squareSize = Utils.dpToPx(15);
                squareMargin = Utils.dpToPx(1);
                break;
            case BIG:
                squareSize = Utils.dpToPx(20);
                squareMargin = Utils.dpToPx(2);
        }
    }
}
