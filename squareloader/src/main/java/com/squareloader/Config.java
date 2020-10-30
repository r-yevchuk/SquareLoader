package com.squareloader;

import android.graphics.Color;
import com.squareloader.utils.Size;
import com.squareloader.utils.Utils;

public final class Config {
    public static final int animationSpeed = 200;
    private static Config instance;
    private int squareSize;
    private int squareMargin;
    private int primaryColor;
    private int secondaryColor;

    private Config() {
        setSize(Size.NORMAL);
        setPrimaryColor("#239B56");
        setSecondaryColor("#82E0AA");
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public int getSquareSize() {
        return squareSize;
    }

    public int getSquareMargin() {
        return squareMargin;
    }

    public int getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = Color.parseColor(primaryColor);
    }

    public int getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = Color.parseColor(secondaryColor);
    }

    public void setSize(Size size) {
        switch (size) {
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
