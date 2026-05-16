package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class database2 extends AppCompatActivity {

    Button btnDisplay;
    TextView tvData;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database2);

        btnDisplay = findViewById(R.id.btnDisplay);
        tvData = findViewById(R.id.tvData);

        db = openOrCreateDatabase("StudentDB", MODE_PRIVATE, null);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor c = db.rawQuery("SELECT * FROM Student", null);

                StringBuffer buffer = new StringBuffer();

                while(c.moveToNext()) {
                    buffer.append("Name: " + c.getString(0) + "\n");
                    buffer.append("Age: " + c.getString(1) + "\n\n");
                }

                tvData.setText(buffer.toString());
            }
        });
    }
}