package com.example.btth04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btth04.R;
import com.example.btth04.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;
    private OnStudentClickListener listener;

    public interface OnStudentClickListener {
        void onEditClick(Student student);
        void onDeleteClick(Student student);
    }

    public StudentAdapter(List<Student> studentList, OnStudentClickListener listener) {
        this.studentList = studentList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.idName2.setText(student.getName());
        holder.idMSV2.setText(student.getMSSV());
        holder.idClass2.setText(student.getStudentClass());
        holder.idGPA2.setText(String.valueOf(student.getGPA()));

        holder.btnEdit.setOnClickListener(v -> listener.onEditClick(student));
        holder.btnDelete.setOnClickListener(v -> listener.onDeleteClick(student));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView idName2, idMSV2, idClass2, idGPA2;
        Button btnEdit, btnDelete;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            idName2 = itemView.findViewById(R.id.idName2);
            idMSV2 = itemView.findViewById(R.id.idMSV2);
            idClass2 = itemView.findViewById(R.id.idClass2);
            idGPA2 = itemView.findViewById(R.id.idGPA2);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}


