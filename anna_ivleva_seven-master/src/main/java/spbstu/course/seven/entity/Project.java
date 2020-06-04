package spbstu.course.seven.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private Integer cost;

  @ManyToOne
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Department department;

  private LocalDate date_beg;
  private LocalDate date_end;
  private LocalDate date_end_real;
}
