package Vakhaev.adapter.persistence.employee;

import Vakhaev.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.login = :employeeLogin")
    Optional<Employee> findByLogin(@Param("employeeLogin") String employeeLogin);
}
