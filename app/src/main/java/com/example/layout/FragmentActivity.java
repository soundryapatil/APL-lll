package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {

    Button btnName, btnEmail, btnClass, btnCollege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        btnName = findViewById(R.id.btnName);
        btnEmail = findViewById(R.id.btnEmail);
        btnClass = findViewById(R.id.btnClass);
        btnCollege = findViewById(R.id.btnCollege);

        btnName.setOnClickListener(v -> loadFragment("My Name is Soundrya"));

        btnEmail.setOnClickListener(v -> loadFragment("Email: soundrya@gmail.com"));

        btnClass.setOnClickListener(v -> loadFragment("Class: B.Tech Final Year"));

        btnCollege.setOnClickListener(v -> loadFragment("College: D Y Patil College"));
    }

    private void loadFragment(String data) {
        Fragment fragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("data", data);
        fragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}
