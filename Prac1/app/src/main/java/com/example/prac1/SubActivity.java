package com.example.prac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    private EditText txtEdt1, txtEdt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_activity);

        txtEdt1 = findViewById(R.id.txtEdt1);
        txtEdt2 = findViewById(R.id.txtEdt2);

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtEdt1.getText().toString();
                String gpa = txtEdt2.getText().toString();


                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name);
                resultIntent.putExtra("gpa", gpa);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}