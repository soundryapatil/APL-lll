package com.example.layout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class progressbar extends AppCompatActivity {

    private CircularProgressIndicator circularProgress;
    private TextView tvPercent;
    private TextView tvStatus;
    private Button btnStart;

    private final Handler handler = new Handler(Looper.getMainLooper());
    private int progress = 0;

    private final Runnable progressRunnable = new Runnable() {
        @Override
        public void run() {
            progress++;
            circularProgress.setProgressCompat(progress, true);
            tvPercent.setText(progress + "%");

            if (progress >= 100) {
                tvStatus.setText("Completed");
                btnStart.setEnabled(true);
                Toast.makeText(progressbar.this, "Completed", Toast.LENGTH_SHORT).show();
                return;
            }

            handler.postDelayed(this, 50);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

        circularProgress = findViewById(R.id.circularProgress);
        tvPercent = findViewById(R.id.tvPercent);
        tvStatus = findViewById(R.id.tvStatus);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(v -> startProgress());
    }

    private void startProgress() {
        handler.removeCallbacks(progressRunnable);
        progress = 0;
        circularProgress.setProgress(0);
        tvPercent.setText("0%");
        tvStatus.setText("In progress...");
        btnStart.setEnabled(false);
        handler.post(progressRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(progressRunnable);
    }
}