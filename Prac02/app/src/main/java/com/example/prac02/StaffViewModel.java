package com.example.prac02;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.Closeable;

public class StaffViewModel extends ViewModel {
    private final MutableLiveData<String> staffData = new MutableLiveData<>();

    @Override
    public void addCloseable(@NonNull Closeable closeable) {
        super.addCloseable(closeable);
    }

    public StaffViewModel(@NonNull Closeable... closeables) {
        super(closeables);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@NonNull Object obj) {
        return super.equals(obj);
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public LiveData<String> getStaffData() {
        return staffData;
    }

    public void addStaff(String staffId, String fullName, String birthDate, String salary) {
        // Tạo chuỗi thông tin nhân viên
        String staffInfo = "Staff id: "+staffId + "\n" +
                "Fullname: "+ fullName + "\n"+
                "Birthdate: " + birthDate +"\n"+
                "Salary: " + salary;

        // Cập nhật LiveData
        staffData.setValue(staffInfo);
    }
}