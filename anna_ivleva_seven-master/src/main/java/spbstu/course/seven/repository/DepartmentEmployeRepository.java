package spbstu.course.seven.repository;

import org.springframework.data.repository.CrudRepository;
import spbstu.course.seven.entity.DepartmentEmploye;

public interface DepartmentEmployeRepository extends CrudRepository<DepartmentEmploye, Long> {
}
