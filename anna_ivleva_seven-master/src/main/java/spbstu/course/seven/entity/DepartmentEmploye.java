package spbstu.course.seven.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
public class DepartmentEmploye {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Department department;

  @ManyToOne
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Employe employe;
}
