package Vakhaev.app.api.employee;

import Vakhaev.domain.employee.Employee;

public interface FindEmployeeByLoginInbound {
    Employee execute(String login);
}
