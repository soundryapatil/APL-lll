package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class calculator27 extends AppCompatActivity {

    EditText editText;

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Button add,sub,mul,div,equal,clear;

    String value1, value2;
    char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator27);

        editText = findViewById(R.id.editText);

        b0=findViewById(R.id.b0);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);

        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        mul=findViewById(R.id.mul);
        div=findViewById(R.id.div);

        equal=findViewById(R.id.equal);
        clear=findViewById(R.id.clear);

        View.OnClickListener numberListener =
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Button b = (Button)v;

                        editText.append(b.getText().toString());
                    }
                };

        b0.setOnClickListener(numberListener);
        b1.setOnClickListener(numberListener);
        b2.setOnClickListener(numberListener);
        b3.setOnClickListener(numberListener);
        b4.setOnClickListener(numberListener);
        b5.setOnClickListener(numberListener);
        b6.setOnClickListener(numberListener);
        b7.setOnClickListener(numberListener);
        b8.setOnClickListener(numberListener);
        b9.setOnClickListener(numberListener);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                value1 = editText.getText().toString();

                operation = '+';

                editText.append("+");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                value1 = editText.getText().toString();

                operation = '-';

                editText.append("-");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                value1 = editText.getText().toString();

                operation = '*';

                editText.append("*");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                value1 = editText.getText().toString();

                operation = '/';

                editText.append("/");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String expression = editText.getText().toString();

                String arr[];

                if(operation == '+')
                    arr = expression.split("\\+");

                else if(operation == '-')
                    arr = expression.split("-");

                else if(operation == '*')
                    arr = expression.split("\\*");

                else
                    arr = expression.split("/");

                int num1 = Integer.parseInt(arr[0]);
                int num2 = Integer.parseInt(arr[1]);

                int result = 0;

                if(operation == '+')
                    result = num1 + num2;

                else if(operation == '-')
                    result = num1 - num2;

                else if(operation == '*')
                    result = num1 * num2;

                else if(operation == '/')
                    result = num1 / num2;

                editText.setText(expression + "=" + result);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText("");
            }
        });
    }
}