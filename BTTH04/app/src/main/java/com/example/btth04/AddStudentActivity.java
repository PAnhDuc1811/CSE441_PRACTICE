package com.example.btth04;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class AddStudentActivity extends AppCompatActivity {

    private EditText edtName, edtMSSV, edtClass, edtGPA;
    private Button btnSave;
    private FirebaseDatabase database;
    private DatabaseReference studentRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        database = FirebaseDatabase.getInstance();
        studentRef = database.getReference("students");
        edtName = findViewById(R.id.edtName);
        edtMSSV = findViewById(R.id.edtMSV);
        edtClass = findViewById(R.id.edtClass);
        edtGPA = findViewById(R.id.edtGPA);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> addStudent());
    }

    private void addStudent() {
        String name = edtName.getText().toString();
        String mssv = edtMSSV.getText().toString();
        String studentClass = edtClass.getText().toString();
        String gpa = edtGPA.getText().toString();

        if (name.isEmpty() || mssv.isEmpty() || studentClass.isEmpty() || gpa.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        studentRef.child(mssv).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Toast.makeText(AddStudentActivity.this, "MSSV đã tồn tại", Toast.LENGTH_SHORT).show();
                } else {

                    Student student = new Student(name, mssv, studentClass, Double.parseDouble(gpa));
                    studentRef.child(mssv).setValue(student).addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(AddStudentActivity.this, "Thêm sinh viên thành công", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(AddStudentActivity.this, "Thêm sinh viên thất bại", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AddStudentActivity.this, "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
