package ru.vsu.demo.entity;

import java.util.Date;
import java.util.Objects;

public class Employee {

    private Long id;
    private Long departmentId;
    private Department department;
    private String name;
    private Date hiredAt;

    public Employee() {

    }

    private Employee(Long departmentId, String name, Date createdAt) {
        this.departmentId = departmentId;
        this.name = name;
        this.hiredAt = createdAt;
    }

    public Department getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public Date getHiredAt() {
        return hiredAt;
    }

    public Long getId() {
        return id;
    }

    public Long getDepartmentId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartment(Department d) {
        this.department = d;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHiredAt(Date createdAt) {
        this.hiredAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee demo = (Employee) o;
        return Objects.equals(id, demo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Employee of(Long departmentId, String name) {
        return new Employee(departmentId, name, new Date());
    }
}
