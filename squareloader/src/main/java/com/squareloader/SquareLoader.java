package com.squareloader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.Nullable;
import com.squareloader.anim.Animation;
import com.squareloader.anim.SpiralAnimation;
import com.squareloader.utils.Size;

public class SquareLoader extends LinearLayout {
    private final Context context;
    private Config config;
    private final ImageView[] ivs = new ImageView[9];

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
        config = new Config();
        setLayoutParams(new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        setOrientation(LinearLayout.VERTICAL);

    }

    private void createImageViews(){
        setPadding(0,0, config.squareMargin, config.squareMargin);
        RelativeLayout.LayoutParams rowParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, config.squareSize);
        rowParams.setMargins(0, config.squareMargin, 0, 0);
        int tag = 0;

        for (int i = 0; i < 3; i++) {
            LinearLayout ll = new LinearLayout(context);
            ll.setLayoutParams(rowParams);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            for (int j = 0; j < 3; j++) {
                ivs[tag] = new ImageView(context);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        config.squareSize, config.squareSize);
                params.setMargins(config.squareMargin, 0, 0, 0);
                ivs[tag].setLayoutParams(params);
                ivs[tag].setBackgroundColor(Config.primaryColor);
                ll.addView(ivs[tag]);
                tag++;
            }
            this.addView(ll);
        }
    }

    public void start() {
        createImageViews();
        Animation animation = new SpiralAnimation(ivs);
        animation.start();
    }

    public void setLoaderSize(Size size){
        config.setSize(size);
    }
}
