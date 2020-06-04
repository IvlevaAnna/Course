package spbstu.course.seven.repository;

import org.springframework.data.repository.CrudRepository;
import spbstu.course.seven.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
