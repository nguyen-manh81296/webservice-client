
<%@ page import="java.util.List" %>
<%@ page import="com.example.webserviceclient.entity.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Employee> listEmployees = (List<Employee>) request.getAttribute("listEmployees");
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="icon" href="/images/logo.png" type="image/x-icon" sizes="20x20">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/assets/css/table-custom.css">
    <link rel="stylesheet" href="/assets/css/header-style.css">
    <title>List Employees</title>
</head>
<body>
<div class="container">
    <h1>List Employees <small>CMS</small></h1>
    <div class="d-flex justify-content-end mb-5">
        <a class="btn button-custom" href="/employees/create"><i class="bi bi-plus-circle"></i> Create</a>
    </div>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">Id</div>
            <div class="col col-1">Name</div>
            <div class="col col-1">Wage</div>
            <div class="col col-1">Action</div>
        </li>
        <%
            for (Employee p : listEmployees
            ) {
        %>
        <li class="table-row">
            <div class="col col-1"><%= p.getId() %>
            </div>
            <div class="col col-1"><%= p.getName() %>
            </div>
            <div class="col col-1"><%= "$" + p.getWage() %>
            </div>
            <div class="col col-1">
                <a href="/employees/update?id=<%= p.getId() %>" type="button"
                   class="btn-action-icon btn-custom-edit"><i
                        class="bi bi-pencil-square"></i></a>
            </div>
        </li>
        <%
            }
        %>
    </ul>
</div>
</body>
</html>
