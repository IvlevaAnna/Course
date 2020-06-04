package spbstu.course.seven.repository;

import org.springframework.data.repository.CrudRepository;
import spbstu.course.seven.entity.Employe;

public interface EmployeRepository extends CrudRepository<Employe, Long> {
}
