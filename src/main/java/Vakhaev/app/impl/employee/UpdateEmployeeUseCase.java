package Vakhaev.app.impl.employee;

import Vakhaev.adapter.persistence.employee.EmployeeRepository;
import Vakhaev.adapter.rest.employee.dto.UpdateEmployeeDto;
import Vakhaev.app.api.employee.UpdateEmployeeInbound;
import Vakhaev.domain.employee.Employee;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateEmployeeUseCase implements UpdateEmployeeInbound {
    private final EmployeeRepository employeeRepository;

    @Transactional
    public String execute(UpdateEmployeeDto updateEmployeeDto, String login) {
        if(!login.equals(updateEmployeeDto.getLogin()) && employeeRepository.existsByLogin(updateEmployeeDto.getLogin())){
            return "employee with new login already exist: " + updateEmployeeDto.getLogin();
        }
        try {
            Employee employee = employeeRepository.findByLogin(login).orElseThrow(() ->
                new EntityNotFoundException("User Not found " + updateEmployeeDto.getLogin()));

            employee.setName(updateEmployeeDto.getName());
            employee.setLogin(updateEmployeeDto.getLogin());
            employee.setSurname(updateEmployeeDto.getSurname());
            employee.setLastName(updateEmployeeDto.getLastName());

            employeeRepository.save(employee);
            return "employee info updated successfully: " + login;
        } catch (EntityNotFoundException e){
            return "error during employee update: " + login;
        }
    }
}
