package ru.vsu.demo.boundary;

import ru.vsu.demo.dal.DepartmentRepository;
import ru.vsu.demo.entity.Department;

import java.util.List;

public class DepartmentService {

    public List<Department> employees() {
        return DepartmentRepository.getInstance().list();
    }

    public Department getById(Long id) {
        return DepartmentRepository.getInstance().getById(id);
    }
}
