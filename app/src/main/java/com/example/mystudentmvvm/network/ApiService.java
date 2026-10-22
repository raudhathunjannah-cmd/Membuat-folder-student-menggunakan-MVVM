package com.example.mystudentmvvm.network;

import com.example.mystudentmvvm.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("students")
    Call<List<Student>> getStudents();
}
