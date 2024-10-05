package com.example.prac02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private StaffViewModel staffViewModel;
    private EditText txtEdt1, txtEdt2, txtEdt3, txtEdt4;
    private TextView txtView1;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo ViewModel
        staffViewModel = new ViewModelProvider(this).get(StaffViewModel.class);

        // Liên kết các view
        txtEdt1 = findViewById(R.id.txtEdt1);
        txtEdt2 = findViewById(R.id.txtEdt2);
        txtEdt3 = findViewById(R.id.txtEdt3);
        txtEdt4 = findViewById(R.id.txtEdt4);
        txtView1 = findViewById(R.id.txtView1);
        btn1 = findViewById(R.id.btn1);

        // Quan sát dữ liệu từ ViewModel
        staffViewModel.getStaffData().observe(this, staffInfo -> {
            if (staffInfo != null) {
                txtView1.setText(staffInfo);
            } else {
                txtView1.setText("No Result!");
            }
        });

        // Thiết lập hành động cho nút "Add New Staff"
        btn1.setOnClickListener(v -> {
            String staffId = txtEdt1.getText().toString();
            String fullName = txtEdt2.getText().toString();
            String birthDate = txtEdt3.getText().toString();
            String salary = txtEdt4.getText().toString();

            // Gọi phương thức thêm nhân viên
            staffViewModel.addStaff(staffId, fullName, birthDate, salary);
        });
    }
}