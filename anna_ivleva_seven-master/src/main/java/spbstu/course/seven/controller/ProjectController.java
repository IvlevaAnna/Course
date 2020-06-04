package spbstu.course.seven.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spbstu.course.seven.entity.Project;
import spbstu.course.seven.repository.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ProjectController {
  private final ProjectRepository projectRepository;

  @GetMapping("project")
  @PreAuthorize("isAuthenticated()")
  public List<Project> getAll() {
    return StreamSupport
        .stream(projectRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @GetMapping("project/{id}")
  @PreAuthorize("isAuthenticated()")
  public Project getOne(@PathVariable("id") Project project) {
    return project;
  }

  @PostMapping("project")
  @PreAuthorize("isAuthenticated()")
  public Project saveOne(@RequestBody Project project) {
    return projectRepository.save(project);
  }

  @PutMapping("project/{id}")
  @PreAuthorize("isAuthenticated()")
  public Project updateOne(@PathVariable("id") Project projectFromDb, @RequestBody Project updatedProject) {
    BeanUtils.copyProperties(updatedProject, projectFromDb, "id");

    return projectRepository.save(projectFromDb);
  }

  @DeleteMapping("project/{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Project project) {
    projectRepository.delete(project);
  }
}

