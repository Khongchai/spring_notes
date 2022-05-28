package com.example.payroll;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor()
class Employee{
    String name;
    String role;

    @Id @GeneratedValue Long id;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
}