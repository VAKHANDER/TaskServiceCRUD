package Vakhaev.app.impl.task;

import Vakhaev.adapter.persistence.employee.EmployeeRepository;
import Vakhaev.adapter.persistence.task.TaskRepository;
import Vakhaev.app.api.task.UpdateTaskInbound;
import Vakhaev.domain.employee.Employee;
import Vakhaev.domain.task.Task;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateTaskUseCase implements UpdateTaskInbound {
    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public String execute(Long id, String name, String priority, String approverLogin, String status, String description) {
        try{
            Task task = taskRepository.findTaskById(id);
            Employee approver = employeeRepository.findByLogin(approverLogin).orElseThrow(EntityNotFoundException::new);

            task.setName(name);
            task.setPriority(priority);
            task.setApprover(approver);
            task.setStatus(status);
            task.setDescription(description);

            taskRepository.save(task);
            return "Task was successfully updated!";
        } catch (Exception e){
            return "Error during task update!";
        }
    }
}
