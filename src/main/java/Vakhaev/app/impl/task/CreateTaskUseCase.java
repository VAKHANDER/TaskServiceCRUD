package Vakhaev.app.impl.task;

import Vakhaev.adapter.persistence.employee.EmployeeRepository;
import Vakhaev.adapter.persistence.task.TaskRepository;
import Vakhaev.app.api.task.CreateTaskInbound;
import Vakhaev.domain.employee.Employee;
import Vakhaev.domain.task.Task;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateTaskUseCase implements CreateTaskInbound {
    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public String execute(String name, String priority, String initiatorLogin, String approverLogin, String status, String description) {
        try {
            Employee initiator = employeeRepository.findByLogin(initiatorLogin).orElseThrow(EntityNotFoundException::new);
            Employee approver = employeeRepository.findByLogin(approverLogin).orElseThrow(EntityNotFoundException::new);

            Task task = new Task(name, priority, status, description);
            task.setInitiator(initiator);
            task.setApprover(approver);

            taskRepository.save(task);
            return "Task was successfully created!";
        } catch (Exception e){
            return "Error during task creating!";
        }
    }
}
