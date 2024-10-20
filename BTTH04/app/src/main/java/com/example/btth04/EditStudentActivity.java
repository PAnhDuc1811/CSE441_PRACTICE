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

public class EditStudentActivity extends AppCompatActivity {

    private EditText edtName2, edtClass2, edtGPA2;
    private Button btnSave2;
    private FirebaseDatabase database;
    private DatabaseReference studentRef;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        database = FirebaseDatabase.getInstance();
        studentRef = database.getReference("students");
        student = (Student) getIntent().getSerializableExtra("student");

        edtName2 = findViewById(R.id.edtName2);
        edtClass2 = findViewById(R.id.edtClass2);
        edtGPA2 = findViewById(R.id.edtGPA2);
        btnSave2 = findViewById(R.id.btnSave2);

        edtName2.setText(student.getName());
        edtClass2.setText(student.getStudentClass());
        edtGPA2.setText(String.valueOf(student.getGPA()));
        btnSave2.setOnClickListener(v -> updateStudent());
    }


        private void updateStudent () {
            String name = edtName2.getText().toString();
            String studentClass = edtClass2.getText().toString();
            String gpa = edtGPA2.getText().toString();

            if (name.isEmpty() || studentClass.isEmpty() || gpa.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            student.setName(name);
            student.setStudentClass(studentClass);
            student.setGPA(Double.parseDouble(gpa));

            studentRef.child(student.getMSSV()).setValue(student).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(EditStudentActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    finish(); // Quay lại màn hình chính
                } else {
                    Toast.makeText(EditStudentActivity.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

