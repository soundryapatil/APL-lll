package com.example.layout;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class programactivity2 extends AppCompatActivity {

    ConstraintLayout mainLayout;
    Button redButton, blueButton, greenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programactivity2);

        mainLayout = findViewById(R.id.mainLayout);
        redButton = findViewById(R.id.redButton);
        blueButton = findViewById(R.id.blueButton);
        greenButton = findViewById(R.id.greenButton);

        redButton.setOnClickListener(v ->
                mainLayout.setBackgroundResource(R.drawable.img));

        blueButton.setOnClickListener(v ->
                mainLayout.setBackgroundResource(R.drawable.img1));

        greenButton.setOnClickListener(v ->
                mainLayout.setBackgroundResource(R.drawable.img2));
    }
}
