package com.example.squareloader;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.squareloader.SquareLoader;
import com.squareloader.utils.Size;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SquareLoader squareLoader = findViewById(R.id.squareLoader);
        squareLoader.setLoaderSize(Size.BIG);
        squareLoader.start();

    }
}
