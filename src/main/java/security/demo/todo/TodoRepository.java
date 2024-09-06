package security.demo.todo;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

  private final EntityManager em;

  public Long save(Todo todo){
    em.persist(todo);
    return todo.getId();
  }

  public Optional<Todo> findById(Long id){
    return Optional.ofNullable(em.find(Todo.class , id));
  }

  public List<Todo> findAll(){
    return em.createQuery("select t from Todo t" , Todo.class).getResultList();
  }


  public void removeById(Todo todo) {
    em.remove(todo);
  }
}
