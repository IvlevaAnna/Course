package spbstu.course.seven.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spbstu.course.seven.entity.Employe;
import spbstu.course.seven.repository.EmployeRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class EmployeController {
  private final EmployeRepository employeRepository;

  @GetMapping("employe")
  @PreAuthorize("isAuthenticated()")
  public List<Employe> getAll() {
    return StreamSupport
        .stream(employeRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @GetMapping("employe/{id}")
  @PreAuthorize("isAuthenticated()")
  public Employe getOne(@PathVariable("id") Employe employe) {
    return employe;
  }

  @PostMapping("employe")
  @PreAuthorize("isAuthenticated()")
  public Employe saveOne(@RequestBody Employe employe) {
    return employeRepository.save(employe);
  }

  @PutMapping("employe/{id}")
  @PreAuthorize("isAuthenticated()")
  public Employe updateOne(@PathVariable("id") Employe employeFromDb, @RequestBody Employe updatedEmploye) {
    BeanUtils.copyProperties(updatedEmploye, employeFromDb, "id");

    return employeRepository.save(employeFromDb);
  }

  @DeleteMapping("employe/{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Employe employe) {
    employeRepository.delete(employe);
  }
}
