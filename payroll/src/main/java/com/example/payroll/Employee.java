package com.example.payroll;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;


@Entity
class Employee{
    String name;
    String role;
    private @Id @GeneratedValue Long id;

    Employee(String name, String role){
        this.name  = name;
        this.role = role;
    }

    public Long getId(){
       return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee employee))
            return false;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
                && Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
    }
}