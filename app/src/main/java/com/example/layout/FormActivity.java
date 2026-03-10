package com.example.layout;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    EditText etName, etEmail;
    RadioGroup radioGroup;
    CheckBox cbReading, cbSports;
    ToggleButton toggleAgree;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        radioGroup = findViewById(R.id.radioGroup);
        cbReading = findViewById(R.id.cbReading);
        cbSports = findViewById(R.id.cbSports);
        toggleAgree = findViewById(R.id.toggleAgree);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String email = etEmail.getText().toString();

            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedGender = findViewById(selectedId);
            String gender = selectedGender != null ? selectedGender.getText().toString() : "Not Selected";

            String hobbies = "";
            if (cbReading.isChecked()) hobbies += "Reading ";
            if (cbSports.isChecked()) hobbies += "Sports ";

            String agree = toggleAgree.isChecked() ? "Agreed" : "Not Agreed";

            tvResult.setText(
                    "Name: " + name + "\n" +
                            "Email: " + email + "\n" +
                            "Gender: " + gender + "\n" +
                            "Hobbies: " + hobbies + "\n" +
                            "Terms: " + agree
            );
        });

        toggleAgree.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(this,
                    isChecked ? "Toggle ON" : "Toggle OFF",
                    Toast.LENGTH_SHORT).show();
        });
    }
}
