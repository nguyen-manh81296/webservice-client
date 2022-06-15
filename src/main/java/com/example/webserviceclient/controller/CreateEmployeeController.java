package com.example.webserviceclient.controller;

import com.example.webserviceclient.service.EmployeeService;
import com.example.webserviceclient.entity.Employee;
import com.example.webserviceclient.retrofit.RetrofitServiceGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateEmployeeController extends HttpServlet{
    private static Employee obj;

    private final EmployeeService employeeService;

    public CreateEmployeeController() {
        employeeService = RetrofitServiceGenerator.createService(EmployeeService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        obj = new Employee("Employee new",1000);
        req.setAttribute("employee", obj);
        req.getRequestDispatcher("/employee/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        obj.setName(req.getParameter("name"));
        obj.setWage(new Double(req.getParameter("wage")));

        employeeService.addEmployees(obj).execute();
        resp.sendRedirect("/employees");
    }
}
