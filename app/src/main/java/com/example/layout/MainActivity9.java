package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity9 extends AppCompatActivity {

    EditText etName;
    Spinner spinnerCourse;
    RadioGroup radioGroup;
    Button btnSubmit, btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        etName = findViewById(R.id.etName);
        spinnerCourse = findViewById(R.id.spinnerCourse);
        radioGroup = findViewById(R.id.radioGroup);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnMenu = findViewById(R.id.btnMenu);

        // ---------- SPINNER ----------
        String[] courses = {"Select Course", "UI Design", "SEO", "Data Visualization", "Computer Networks"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                courses
        );

        spinnerCourse.setAdapter(adapter);

        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String course = spinnerCourse.getSelectedItem().toString();

            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadio = findViewById(selectedId);
            String gender = selectedRadio != null ? selectedRadio.getText().toString() : "Not Selected";

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity9.this);
            builder.setTitle("Form Details");
            builder.setMessage("Name: " + name +
                    "\nCourse: " + course +
                    "\nGender: " + gender);

            builder.setPositiveButton("OK", null);
            builder.show();
        });

        // ---------- POPUP MENU ----------
        btnMenu.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(MainActivity9.this, btnMenu);

            popup.getMenu().add("Profile");
            popup.getMenu().add("Settings");
            popup.getMenu().add("Logout");

            popup.setOnMenuItemClickListener(item -> {
                Toast.makeText(MainActivity9.this,
                        "Selected: " + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                return true;
            });

            popup.show();
        });
    }
}