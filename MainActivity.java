package com.example.calculatorapp;

import static com.example.calculatorapp.R.id.btn_add;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    // ✅ Final Static Constants Banayein
    private static final int ADD = 1;
    private static final int SUB = 2;
    private static final int MUL = 3;
    private static final int DIV = 4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        // ✅ Har Button Par Click Listener Lagayein
        buttonAdd.setOnClickListener(view -> handleClick(ADD));
        buttonSub.setOnClickListener(view -> handleClick(SUB));
        buttonMul.setOnClickListener(view -> handleClick(MUL));
        buttonDiv.setOnClickListener(view -> handleClick(DIV));
    }

    // ✅ Yeh method EditText se value lega
    public int getIntFromEditText(EditText editText) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }

    // ✅ Switch Case Ko Handle Karne Ke Liye Method
    private void handleClick(int operation) {
        num1 = getIntFromEditText(editTextN1);
        num2 = getIntFromEditText(editTextN2);

        switch (operation) {
            case ADD:
                textView.setText("Answer = " + (num1 + num2));
                break;
            case SUB:
                textView.setText("Answer = " + (num1 - num2));
                break;
            case MUL:
                textView.setText("Answer = " + (num1 * num2));
                break;
            case DIV:
                if (num2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                } else {
                    textView.setText("Answer = " + ((float) num1 / num2));
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {

    }
}
