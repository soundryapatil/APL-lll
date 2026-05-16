package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class database3 extends AppCompatActivity {

    EditText etOldName, etNewAge;
    Button btnUpdate;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database3);

        etOldName = findViewById(R.id.etOldName);
        etNewAge = findViewById(R.id.etNewAge);
        btnUpdate = findViewById(R.id.btnUpdate);

        db = openOrCreateDatabase("StudentDB", MODE_PRIVATE, null);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etOldName.getText().toString();
                String age = etNewAge.getText().toString();

                db.execSQL("UPDATE Student SET age='" + age +
                        "' WHERE name='" + name + "'");

                Toast.makeText(database3.this,
                        "Data Updated Successfully",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}