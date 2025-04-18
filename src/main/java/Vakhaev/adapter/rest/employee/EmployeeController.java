package Vakhaev.adapter.rest.employee;

import Vakhaev.adapter.rest.employee.dto.SignUpDto;
import Vakhaev.adapter.rest.employee.dto.UpdateEmployeeDto;
import Vakhaev.app.api.employee.*;
import Vakhaev.domain.employee.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TMS-rest/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final FindAllEmployeesInbound findAllEmployeesInbound;
    private final FindEmployeeByLoginInbound findEmployeeByLoginInbound;
    private final UpdateEmployeeInbound updateEmployeeInbound;
    private final CreateEmployeeInbound createEmployeeInbound;
    private final DeleteEmployeeByLoginInbound deleteEmployeeByLoginInbound;

    @GetMapping("/find-all-employees")
    public List<Employee> getAllEmployees(){
        return findAllEmployeesInbound.execute();
    }

    @GetMapping("/find-{login}")
    public Employee findEmployeeById(@PathVariable String login){
        return findEmployeeByLoginInbound.execute(login);
    }

    @PostMapping("/update-employee-{login}")
    public String updateEmployeeInfo(@RequestBody UpdateEmployeeDto updateEmployeeDto, @PathVariable String login){
        return updateEmployeeInbound.execute(updateEmployeeDto, login);
    }

    @PostMapping("/create-employee")
    public String createEmployee(@RequestBody SignUpDto signUpDto){
        return createEmployeeInbound.execute(signUpDto.getName(),
            signUpDto.getSurname(),
            signUpDto.getLastName(),
            signUpDto.getLogin(),
            signUpDto.getPassword());
    }

    @DeleteMapping("/delete-employee-{login}")
    public String deleteEmployee(@PathVariable String login){
        return deleteEmployeeByLoginInbound.execute(login);
    }
}
