package Vakhaev.app.api.employee;

import Vakhaev.adapter.rest.employee.dto.UpdateEmployeeDto;

public interface UpdateEmployeeInbound {
    String execute(UpdateEmployeeDto updateEmployeeDto, String login);
}
