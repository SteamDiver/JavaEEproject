package ru.vsu.demo.dal;

import ru.vsu.demo.entity.Department;

import java.util.List;

public class DepartmentRepository {
    private Mapper<Department> departmentMapper = resultSet -> {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");

        Department department = new Department();
        department.setId(id);
        department.setName(name);
        return department;
    };

    private EntityManager entityManager = EntityManager.getInstance();
    private static DepartmentRepository instance;

    private DepartmentRepository(){

    }

    public static DepartmentRepository getInstance(){
        if(instance == null)
            instance = new DepartmentRepository();
        return instance;
    }

    public List<Department> list(){
        String query = "select * from departments";
        return entityManager.executeQuery(query, departmentMapper);
    }

    public Department getById(Long id) {
        String query = String.format("select * from departments where id = %d", id);
        List<Department> deps = entityManager.executeQuery(query, departmentMapper);
        if (deps != null && !deps.isEmpty()) {
            return deps.get(0);
        }
        return null;
    }

    public Long count() {
        String query = "select count(1) from departments";
        List<Long> list = entityManager.executeQuery(query, resultSet -> resultSet.getLong(1));
        if (list == null || list.isEmpty()) {
            return 0L;
        }
        return list.get(0);
    }
}
