package com.example.squareloader;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.squareloader.SquareLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SquareLoader squareLoader = new SquareLoader(this);
        squareLoader.start();

        ConstraintLayout bkg = findViewById(R.id.bkg);
        bkg.addView(squareLoader);
    }
}
