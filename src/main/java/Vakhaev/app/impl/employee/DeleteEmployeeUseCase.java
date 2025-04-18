package Vakhaev.app.impl.employee;

import Vakhaev.adapter.persistence.employee.EmployeeRepository;
import Vakhaev.app.api.employee.DeleteEmployeeByLoginInbound;
import Vakhaev.domain.employee.Employee;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteEmployeeUseCase implements DeleteEmployeeByLoginInbound {
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public String execute(String login) {
        try {
            Employee employee = employeeRepository.findByLogin(login).orElseThrow(() -> new EntityNotFoundException("employee was not found"));

            employeeRepository.delete(employee);

            return "Employee was deleted: " + employee.getLogin();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
