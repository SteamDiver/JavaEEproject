package ru.vsu.demo.view;

import ru.vsu.demo.boundary.DepartmentService;
import ru.vsu.demo.boundary.EmployeeService;
import ru.vsu.demo.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.util.Collections.emptyList;

@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        super.init();
        employeeService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Employee> employees = employeeService.employees();
        if (employees == null) {
            employees = emptyList();
        }
        req.setAttribute("employees", employees);

        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }
}
