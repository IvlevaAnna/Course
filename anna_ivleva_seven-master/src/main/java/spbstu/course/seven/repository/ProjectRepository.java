package spbstu.course.seven.repository;

import org.springframework.data.repository.CrudRepository;
import spbstu.course.seven.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
