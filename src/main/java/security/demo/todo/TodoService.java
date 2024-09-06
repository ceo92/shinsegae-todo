package security.demo.todo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {
  private final TodoRepository todoRepository;

  @Transactional
  public Long saveTodo(TodoSaveDto todoSaveDto){
    String title = todoSaveDto.getTitle();
    LocalDate date = todoSaveDto.getDate();
    Boolean isDone = todoSaveDto.getIsDone();
    Todo todo = Todo.createTodo(title, date, isDone);
    return todoRepository.save(todo);
  }

  @Transactional
  public void update(Long id , TodoUpdateDto todoUpdateDto){
    Todo todo = findOne(id);
    todo.setTitle(todoUpdateDto.getTitle());
    todo.setDate(todoUpdateDto.getDate());
    todo.setIsDone(todoUpdateDto.getIsDone());
  }

  public Todo findOne(Long id){
    return todoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("없는 id입니다!"));
  }

  public List<Todo> findTodos(){
    return todoRepository.findAll();
  }

  @Transactional
  public void removeOne(Long id){
    Todo todo = findOne(id);
    todoRepository.removeById(todo);
  }

}
