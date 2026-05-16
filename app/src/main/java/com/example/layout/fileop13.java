package com.example.layout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class fileop13 extends AppCompatActivity {

    EditText editText;
    Button btnWrite, btnRead;
    TextView textView;

    String fileName = "myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fileop13);

        editText = findViewById(R.id.editText);
        btnWrite = findViewById(R.id.btnWrite);
        btnRead = findViewById(R.id.btnRead);
        textView = findViewById(R.id.textView);

        // WRITE FILE
        btnWrite.setOnClickListener(v -> {
            String data = editText.getText().toString();

            try {
                FileOutputStream fos = openFileOutput(fileName, MODE_APPEND);
                fos.write(data.getBytes());
                fos.write("\n".getBytes());
                fos.close();

                Toast.makeText(fileop13.this, "Data Written", Toast.LENGTH_SHORT).show();
                editText.setText("");

            } catch (Exception e) {
                Toast.makeText(fileop13.this, "Error Writing File", Toast.LENGTH_SHORT).show();
            }
        });

        // READ FILE
        btnRead.setOnClickListener(v -> {
            try {
                FileInputStream fis = openFileInput(fileName);
                int i;
                StringBuilder data = new StringBuilder();

                while ((i = fis.read()) != -1) {
                    data.append((char) i);
                }

                fis.close();
                textView.setText(data.toString());

            } catch (Exception e) {
                textView.setText("No Data Found");
            }
        });
    }
}