package com.example.webserviceclient.controller;

import com.example.webserviceclient.service.EmployeeService;
import com.example.webserviceclient.entity.Employee;
import com.example.webserviceclient.retrofit.RetrofitServiceGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetEmployeeController extends HttpServlet {
    EmployeeService employeeService;

    public GetEmployeeController(){
        employeeService = RetrofitServiceGenerator.createService(EmployeeService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeService.getEmployees().execute().body();
        req.setAttribute("employees",employees);
        req.getRequestDispatcher("/employees/list.jsp").forward(req,resp);
    }
}
