package spbstu.course.seven.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spbstu.course.seven.entity.Department;
import spbstu.course.seven.repository.DepartmentRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class DepartmentController {
  private final DepartmentRepository departmentRepository;

  @GetMapping("department")
  @PreAuthorize("isAuthenticated()")
  public List<Department> getAll() {
    return StreamSupport
        .stream(departmentRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @GetMapping("department/{id}")
  @PreAuthorize("isAuthenticated()")
  public Department getOne(@PathVariable("id") Department department) {
    return department;
  }

  @PostMapping("department")
  @PreAuthorize("isAuthenticated()")
  public Department saveOne(@RequestBody Department department) {
    return departmentRepository.save(department);
  }

  @PutMapping("department/{id}")
  @PreAuthorize("isAuthenticated()")
  public Department updateOne(@PathVariable("id") Department departmentFromDb,
                              @RequestBody Department updateDepartment) {
    BeanUtils.copyProperties(updateDepartment, departmentFromDb, "id");

    return departmentRepository.save(departmentFromDb);
  }

  @DeleteMapping("department/{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Department department) {
    departmentRepository.delete(department);
  }
}
