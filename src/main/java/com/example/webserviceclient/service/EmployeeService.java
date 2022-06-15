package com.example.webserviceclient.service;

import com.example.webserviceclient.entity.Employee;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface EmployeeService {
    @GET("/api/v1/employees")
    public Call<List<Employee>> getEmployees();

    @GET("api/v1/employees/{id}")
    public Call<Employee> getEmployeeDetails(@Path("id") Integer id);

    @POST("api/v1/employees")
    public Call<Employee> addEmployees(@Body Employee employee);

    @PUT("api/v1/employees/{id}")
    public Call<Boolean> updateEmployees(@Path("id") Integer id, @Body Employee employee);
}

