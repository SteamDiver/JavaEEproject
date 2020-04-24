package ru.vsu.demo.dal;

import ru.vsu.demo.entity.Employee;

import java.sql.Date;
import java.util.List;

public class EmployeeRepository {
    private Mapper<Employee> employeeMapper = resultSet -> {
        long id = resultSet.getLong("id");
        long departmentId = resultSet.getLong("departmentId");
        String name = resultSet.getString("name");
        Date hiredAt = resultSet.getDate("hiredAt");

        Employee employee = new Employee();
        employee.setId(id);
        employee.setDepartmentId(departmentId);
        employee.setName(name);
        employee.setHiredAt(hiredAt);
        return employee;
    };

    private EntityManager entityManager = EntityManager.getInstance();

    private static EmployeeRepository instance;

    private EmployeeRepository(){

    }

    public static EmployeeRepository getInstance(){
        if(instance == null)
            instance = new EmployeeRepository();
        return instance;
    }

    public List<Employee> list(){
        String query = "select * from employees";
        return entityManager.executeQuery(query, employeeMapper);
    }

    public Employee getById(Long id) {
        String query = String.format("select * from employees where id = %d", id);
        List<Employee> employees = entityManager.executeQuery(query, employeeMapper);
        if (employees != null && !employees.isEmpty()) {
            return employees.get(0);
        }
        return null;
    }

    public Long count() {
        String query = "select count(1) from employees";
        List<Long> list = entityManager.executeQuery(query, resultSet -> resultSet.getLong(1));
        if (list == null || list.isEmpty()) {
            return 0L;
        }
        return list.get(0);
    }
}
