package com.droidknights.droidtest.step2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.droidknights.droidtest.R;

public class Step2Activity extends AppCompatActivity {
    private TextView editText;

    private Step2Calculator calculator = new Step2Calculator();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator);

        editText = findViewById(R.id.calculator_edit_text);

        findViewById(R.id.calculator_button_0).setOnClickListener(button -> setText("0"));
        findViewById(R.id.calculator_button_1).setOnClickListener(button -> setText("1"));
        findViewById(R.id.calculator_button_2).setOnClickListener(button -> setText("2"));
        findViewById(R.id.calculator_button_3).setOnClickListener(button -> setText("3"));
        findViewById(R.id.calculator_button_4).setOnClickListener(button -> setText("4"));
        findViewById(R.id.calculator_button_5).setOnClickListener(button -> setText("5"));
        findViewById(R.id.calculator_button_6).setOnClickListener(button -> setText("6"));
        findViewById(R.id.calculator_button_7).setOnClickListener(button -> setText("7"));
        findViewById(R.id.calculator_button_8).setOnClickListener(button -> setText("8"));
        findViewById(R.id.calculator_button_0).setOnClickListener(button -> setText("9"));

        findViewById(R.id.calculator_button_plus).setOnClickListener(button     -> setText("+"));
        findViewById(R.id.calculator_button_minus).setOnClickListener(button    -> setText("-"));
        findViewById(R.id.calculator_button_multiply).setOnClickListener(button -> setText("*"));
        findViewById(R.id.calculator_button_divide).setOnClickListener(button   -> setText("/"));

        findViewById(R.id.calculator_button_result).setOnClickListener(button -> calculate());
    }

    private void setText(String number) {
        editText.append(number);
    }

    private void calculate() {
        String expression = editText.getText().toString();

        String result = calculator.calculate(expression);

        editText.setText(result);
    }
}
