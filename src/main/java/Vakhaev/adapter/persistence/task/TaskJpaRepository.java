package Vakhaev.adapter.persistence.task;

import Vakhaev.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJpaRepository extends JpaRepository<Task, Long> {
}
