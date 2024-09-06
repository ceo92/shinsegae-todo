package security.demo.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Getter @Setter
public class Todo {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @NumberFormat(pattern = "yyyy-MM-dd")
  private LocalDate date;

  private Boolean isDone;

  public static Todo createTodo(String title , LocalDate date , Boolean isDone){
    Todo todo = new Todo();
    todo.setTitle(title);
    todo.setDate(date);
    todo.setIsDone(isDone);
    return todo;
  }
}
