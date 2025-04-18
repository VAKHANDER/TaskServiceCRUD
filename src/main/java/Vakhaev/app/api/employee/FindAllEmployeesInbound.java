package Vakhaev.app.api.employee;

import Vakhaev.domain.employee.Employee;

import java.util.List;

public interface FindAllEmployeesInbound {
    List<Employee> execute();
}
