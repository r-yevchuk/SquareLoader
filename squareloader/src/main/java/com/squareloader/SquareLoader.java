package com.squareloader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.squareloader.anim.*;
import com.squareloader.utils.Size;

public class SquareLoader extends LinearLayout {
    private final Context context;
    private final ImageView[] ivs = new ImageView[9];
    private Config config;
    private AnimationType type;

    public SquareLoader(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public SquareLoader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public SquareLoader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        config = Config.getInstance();
        setLayoutParams(new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        setOrientation(LinearLayout.VERTICAL);
    }

    private void createImageViews() {
        int margin = config.getSquareMargin();
        int squareSize = config.getSquareSize();

        setPadding(0, 0, margin, margin);
        RelativeLayout.LayoutParams rowParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, squareSize);
        rowParams.setMargins(0, margin, 0, 0);
        int tag = 0;

        for (int i = 0; i < 3; i++) {
            LinearLayout ll = new LinearLayout(context);
            ll.setLayoutParams(rowParams);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            for (int j = 0; j < 3; j++) {
                ivs[tag] = new ImageView(context);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        squareSize, squareSize);
                params.setMargins(margin, 0, 0, 0);
                ivs[tag].setLayoutParams(params);
                ivs[tag].setBackgroundColor(config.getPrimaryColor());
                ll.addView(ivs[tag]);
                tag++;
            }
            this.addView(ll);
        }
    }

    public void start() {
        createImageViews();

        Animation animation;
        switch (type) {
            case LINEAR:
                animation = new LinearAnimation(ivs, config);
                break;
            case ROUND:
                animation = new RoundAnimation(ivs, config);
                break;
            default:
                animation = new SpiralAnimation(ivs, config);
        }
        animation.start();
    }

    public void setLoaderSize(Size size) {
        config.setSize(size);
    }

    public void setPrimaryColor(String primaryColor) {
        config.setPrimaryColor(primaryColor);
    }

    public void setSecondaryColor(String secondaryColor) {
        config.setSecondaryColor(secondaryColor);
    }

    public void setAnimationType(AnimationType type) {
        this.type = type;
    }
}
