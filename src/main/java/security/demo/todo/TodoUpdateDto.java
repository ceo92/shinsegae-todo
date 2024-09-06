package security.demo.todo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TodoUpdateDto {
  private String title;
  private LocalDate date;

  private Boolean isDone;
}
