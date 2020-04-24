package ru.vsu.demo.boundary;

import ru.vsu.demo.dal.DepartmentRepository;
import ru.vsu.demo.dal.EmployeeRepository;
import ru.vsu.demo.entity.Employee;

import java.util.List;

public class EmployeeService {

    public List<Employee> employees() {
        List<Employee> employees = EmployeeRepository.getInstance().list();
        if (employees != null) {
            for (Employee employee :
                    employees) {
                employee.setDepartment(DepartmentRepository.getInstance().getById(employee.getDepartmentId()));
            }
            return employees;
        }
        return null;
    }

    public Employee getById(Long id) {
        return EmployeeRepository.getInstance().getById(id);
    }
}
