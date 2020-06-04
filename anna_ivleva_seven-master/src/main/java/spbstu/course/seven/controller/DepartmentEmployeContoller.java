package spbstu.course.seven.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spbstu.course.seven.entity.DepartmentEmploye;
import spbstu.course.seven.repository.DepartmentEmployeRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class DepartmentEmployeContoller {
  private final DepartmentEmployeRepository departmentEmployeRepository;

  @GetMapping("departmentEmploye")
  @PreAuthorize("isAuthenticated()")
  public List<DepartmentEmploye> getAll() {
    return StreamSupport
        .stream(departmentEmployeRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("departmentEmploye/{id}")
  public DepartmentEmploye getOne(@PathVariable("id") DepartmentEmploye departmentEmploye) {
    return departmentEmploye;
  }

  @PostMapping("departmentEmploye")
  @PreAuthorize("isAuthenticated()")
  public DepartmentEmploye saveOnt(@RequestBody DepartmentEmploye departmentEmploye) {
    return departmentEmployeRepository.save(departmentEmploye);
  }

  @PreAuthorize("isAuthenticated()")
  @PutMapping("departmentEmploye/{id}")
  public DepartmentEmploye updateUp(@PathVariable("id") DepartmentEmploye departmentEmployeFromDb,
                                    @RequestBody DepartmentEmploye updatedDepartmentEmploye) {
    BeanUtils.copyProperties(updatedDepartmentEmploye, departmentEmployeFromDb, "id");

    return departmentEmployeRepository.save(departmentEmployeFromDb);
  }


  @PreAuthorize("isAuthenticated()")
  @DeleteMapping("departmentEmploye/{id}")
  public void deleteOne(@PathVariable("id") DepartmentEmploye departmentEmploye) {
    departmentEmployeRepository.delete(departmentEmploye);
  }
}
