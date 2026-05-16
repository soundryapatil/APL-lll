package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity9b extends AppCompatActivity {

    EditText num1, num2;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity9b);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        btnAdd.setOnClickListener(v -> calculate("+"));
        btnSub.setOnClickListener(v -> calculate("-"));
        btnMul.setOnClickListener(v -> calculate("*"));
        btnDiv.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String operator) {

        String val1 = num1.getText().toString();
        String val2 = num2.getText().toString();

        if (val1.isEmpty() || val2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(val1);
        double n2 = Double.parseDouble(val2);
        double result = 0;

        switch (operator) {
            case "+":
                result = n1 + n2;
                Toast.makeText(this, "Addition is " + result, Toast.LENGTH_SHORT).show();
                break;

            case "-":
                result = n1 - n2;
                Toast.makeText(this, "Subtraction is " + result, Toast.LENGTH_SHORT).show();
                break;

            case "*":
                result = n1 * n2;
                Toast.makeText(this, "Multiplication is " + result, Toast.LENGTH_SHORT).show();
                break;

            case "/":
                if (n2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                } else {
                    result = n1 / n2;
                    Toast.makeText(this, "Division is " + result, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}