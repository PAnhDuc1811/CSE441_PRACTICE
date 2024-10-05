package com.example.project_cal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button btn1, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3= findViewById(R.id.editText3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+editText1.getText());
                int b = Integer.parseInt("0"+editText2.getText());
// TODO Auto-generated method stub
                editText3.setText("a + b =" +(a+b));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+editText1.getText());
                int b = Integer.parseInt("0"+editText2.getText());
// TODO Auto-generated method stub
                editText3.setText("a - b =" +(a-b));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+editText1.getText());
                int b = Integer.parseInt("0"+editText2.getText());
// TODO Auto-generated method stub
                editText3.setText("a * b =" +(a*b));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                int a = Integer.parseInt("0"+editText1.getText());
                int b = Integer.parseInt("0"+editText2.getText());
                if (b == 0)
                {
                    editText3.setText("B phai khac 0");
                }
else
                {
                    editText3.setText("a / b =" +(a/b));
                }
            }
        });
    }

}





