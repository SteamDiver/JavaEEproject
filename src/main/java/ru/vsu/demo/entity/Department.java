package ru.vsu.demo.entity;

import java.util.Date;
import java.util.Objects;

public class Department {

    private Long id;

    private String name;


    public Department() {

    }

    private Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department demo = (Department) o;
        return Objects.equals(id, demo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Department of(String name) {
        return new Department(name);
    }
}
