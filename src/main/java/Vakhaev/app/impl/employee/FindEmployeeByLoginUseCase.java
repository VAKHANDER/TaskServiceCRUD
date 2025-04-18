package Vakhaev.app.impl.employee;

import Vakhaev.adapter.persistence.employee.EmployeeRepository;
import Vakhaev.app.api.employee.FindEmployeeByLoginInbound;
import Vakhaev.domain.employee.Employee;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindEmployeeByLoginUseCase implements FindEmployeeByLoginInbound {
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee execute(String login) {
        return employeeRepository.findByLogin(login).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }
}
