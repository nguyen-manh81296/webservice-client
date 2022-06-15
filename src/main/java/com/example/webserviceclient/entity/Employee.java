package com.example.webserviceclient.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {
    private int id;
    private String name;
    private double wage;

    public Employee(String name, double wage) {
        this.name = name;
        this.wage = wage;
    }
}
