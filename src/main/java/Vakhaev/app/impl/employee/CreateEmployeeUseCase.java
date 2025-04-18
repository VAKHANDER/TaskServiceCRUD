package Vakhaev.app.impl.employee;

import Vakhaev.adapter.persistence.employee.EmployeeRepository;
import Vakhaev.app.api.employee.CreateEmployeeInbound;
import Vakhaev.domain.employee.Employee;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateEmployeeUseCase implements CreateEmployeeInbound {
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public String execute(String name, String surname, String lastName, String login, String password) {
        try {
            Employee employee = new Employee(name, surname, lastName, login, password);

            validateLogin(employee.getLogin());

            employeeRepository.save(employee);
            return "Employee was created!";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private void validateLogin(String login){
        if (employeeRepository.existsByLogin(login)){
            throw new EntityNotFoundException("Employee already registered");
        }
    }
}
