package com.example.webserviceclient.controller;

import com.example.webserviceclient.service.EmployeeService;
import com.example.webserviceclient.entity.Employee;
import com.example.webserviceclient.retrofit.RetrofitServiceGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UpdateEmployeeController extends HttpServlet {
    private static Employee obj;

    private final EmployeeService employeeService;

    public UpdateEmployeeController() {
        employeeService = RetrofitServiceGenerator.createService(EmployeeService.class);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        obj = employeeService.getEmployeeDetail(id).execute().body();
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        } else {
            req.setAttribute("employee", obj);
            req.getRequestDispatcher("/employee/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        obj.setName(req.getParameter("name"));
        obj.setWage(new Double(req.getParameter("wage")));

        employeeService.update(id,obj).execute();
        resp.sendRedirect("/employees");
    }
}
