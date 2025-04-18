package Vakhaev.app.impl.employee;

import Vakhaev.adapter.persistence.employee.EmployeeRepository;
import Vakhaev.app.api.employee.FindAllEmployeesInbound;
import Vakhaev.domain.employee.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllEmployeesUseCase implements FindAllEmployeesInbound {
    private final EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> execute(){
        return employeeRepository.findAll();
    }
}
