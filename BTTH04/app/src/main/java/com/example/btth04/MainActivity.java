package com.example.btth04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.btth04.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private List<Student> studentList;
    private FirebaseDatabase database;
    private DatabaseReference studentRef;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        studentRef = database.getReference("students");

        studentList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new StudentAdapter(studentList, new StudentAdapter.OnStudentClickListener() {
            @Override
            public void onEditClick(Student student) {
                Intent intent = new Intent(com.example.btth04.MainActivity.this, EditStudentActivity.class);
                intent.putExtra("student", student);
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(Student student) {
                studentRef.child(student.getMSSV()).removeValue();
            }
        });
        recyclerView.setAdapter(adapter);

        studentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                studentList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Student student = dataSnapshot.getValue(Student.class);
                    studentList.add(student);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(com.example.btth04.MainActivity.this, "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnAddStudent = findViewById(R.id.btnAddStudent);
        btnAddStudent.setOnClickListener(v -> {
            Intent intent = new Intent(com.example.btth04.MainActivity.this, AddStudentActivity.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

}

