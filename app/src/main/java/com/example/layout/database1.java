package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class database1 extends AppCompatActivity {

    EditText etName, etAge;
    Button btnInsert;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database1);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnInsert = findViewById(R.id.btnInsert);

        db = openOrCreateDatabase("StudentDB", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS Student(name VARCHAR, age VARCHAR)");

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String age = etAge.getText().toString();

                db.execSQL("INSERT INTO Student VALUES('" + name + "','" + age + "')");

                Toast.makeText(database1.this,
                        "Data Inserted Successfully",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}