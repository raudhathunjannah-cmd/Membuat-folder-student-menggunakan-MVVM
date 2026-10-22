package com.example.mystudentmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mystudentmvvm.model.Student;
import com.example.mystudentmvvm.viewmodel.StudentViewModel;

public class MainActivity extends AppCompatActivity {


    private StudentViewModel studentViewModel;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);

        //ambil data students
        studentViewModel.getStudents().observe(this, students -> {
            for (Student student: students) {
                Log.d(TAG, "onCreate: "+ student.name());

                //Toast.makeText(this, student.name(), Toast.LENGTH_SHORT).show();


            }
        });

        //ambil data eror
        studentViewModel.getErrorMessage().observe(this, errorMessage -> {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        });
    }
}