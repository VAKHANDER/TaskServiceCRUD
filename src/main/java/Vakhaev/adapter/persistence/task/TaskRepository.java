package Vakhaev.adapter.persistence.task;

import Vakhaev.domain.task.Task;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepository {
    private final TaskJpaRepository taskJpaRepository;

    public List<Task> findAllTasks(){
        return taskJpaRepository.findAll();
    }

    public Task findTaskById(Long id){
        return taskJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found"));
    }

    public void save(Task task){
        taskJpaRepository.save(task);
    }

    public void delete(Long id){
        Task task = findTaskById(id);
        taskJpaRepository.delete(task);
    }
}
