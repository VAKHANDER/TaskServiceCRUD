package Vakhaev.adapter.persistence.employee;

import Vakhaev.domain.employee.Employee;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {
    private final EmployeeJpaRepository employeeJpaRepository;

    public List<Employee> findAll(){
        return employeeJpaRepository.findAll();
    }

    public Optional<Employee> findByLogin(String login){
        return employeeJpaRepository.findByLogin(login);
    }

    public Employee findById(Long id){
        return employeeJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void save(Employee employee){
        employeeJpaRepository.save(employee);
    }

    public boolean existsByLogin(String login){
        return findByLogin(login).isPresent();
    }

    public void delete(Employee employee){
        employeeJpaRepository.delete(employee);
    }
}
