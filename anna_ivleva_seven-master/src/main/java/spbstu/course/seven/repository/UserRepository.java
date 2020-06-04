package spbstu.course.seven.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.course.seven.authentication.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String name);
}