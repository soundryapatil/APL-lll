package com.example.layout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class programactivity1 extends AppCompatActivity {

    ConstraintLayout mainLayout;
    Button redButton, blueButton, greenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programactivity1);

        Log.d("lifecycle", "onCreate invoked");

        mainLayout = findViewById(R.id.mainLayout);
        redButton = findViewById(R.id.redButton);
        blueButton = findViewById(R.id.blueButton);
        greenButton = findViewById(R.id.greenButton);

        redButton.setOnClickListener(v ->
                mainLayout.setBackgroundColor(Color.RED));

        blueButton.setOnClickListener(v ->
                mainLayout.setBackgroundColor(Color.BLUE));

        greenButton.setOnClickListener(v ->
                mainLayout.setBackgroundColor(Color.GREEN));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "onDestroy invoked");
    }
}