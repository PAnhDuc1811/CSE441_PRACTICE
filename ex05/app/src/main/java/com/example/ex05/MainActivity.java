package com.example.ex05;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends Activity {
    // Declare variables for UI components
    Button btntieptuc, btngiaipt, btnthoat;
    EditText edita, editb, editc;
    TextView txtkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind UI elements
        btntieptuc = findViewById(R.id.btntieptuc);
        btngiaipt = findViewById(R.id.btngiaipt);
        btnthoat = findViewById(R.id.btnthoat);
        edita = findViewById(R.id.edta);
        editb = findViewById(R.id.edtb);
        editc = findViewById(R.id.edtc);
        txtkq = findViewById(R.id.txtkq);

        // Button click event to solve the quadratic equation
        btngiaipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Get input from EditText fields
                    String sa = edita.getText().toString();
                    String sb = editb.getText().toString();
                    String sc = editc.getText().toString();

                    // Parse the inputs
                    int a = Integer.parseInt(sa);
                    int b = Integer.parseInt(sb);
                    int c = Integer.parseInt(sc);

                    // Solve the quadratic equation
                    solveQuadraticEquation(a, b, c);
                } catch (NumberFormatException e) {
                    txtkq.setText("Vui lòng nhập đúng hệ số!");
                }
            }
        });

        // Button click event to reset the input fields
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetInputs();
            }
        });

        // Button click event to exit the app
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Exit the application
            }
        });
    }

    // Method to solve the quadratic equation
    private void solveQuadraticEquation(int a, int b, int c) {
        String kq = "";
        DecimalFormat dcf = new DecimalFormat("0.00");

        if (a == 0) {
            if (b == 0) {
                kq = (c == 0) ? "Phương trình vô số nghiệm" : "Phương trình vô nghiệm";
            } else {
                kq = "Phương trình có 1 nghiệm: x = " + dcf.format(-c / (float) b);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                kq = "Phương trình vô nghiệm";
            } else if (delta == 0) {
                kq = "Phương trình có nghiệm kép: x1 = x2 = " + dcf.format(-b / (2.0 * a));
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                kq = "Phương trình có 2 nghiệm: x1 = " + dcf.format(x1) + ", x2 = " + dcf.format(x2);
            }
        }

        // Display result in TextView
        txtkq.setText(kq);
    }

    // Method to reset input fields
    private void resetInputs() {
        edita.setText("");
        editb.setText("");
        editc.setText("");
        txtkq.setText("");
        edita.requestFocus(); // Set focus back to the first input field
    }
}
