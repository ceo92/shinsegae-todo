package security.demo.todo;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class TodoController {
  private final TodoService todoService;

  @GetMapping("asddsa")
  public String djs(){
    
  }

  @GetMapping("todo/register")
  public String aa(Model model){
    model.addAttribute("todo"  , new TodoSaveDto());
    return "saveTodo";
  }

  @PostMapping("todo/register")
  public String bb(@ModelAttribute("todo") TodoSaveDto todoSaveDto , RedirectAttributes redirectAttributes){
    Long saveId = todoService.saveTodo(todoSaveDto);
    redirectAttributes.addAttribute("registerStatus" , true);
    redirectAttributes.addAttribute("id" ,saveId); //리다이렉트되는 주소에 대한 model.addattribute하는것
    return "redirect:/todo/list";
  }

  @GetMapping("todo/list")
  public String cc(Model model){
    List<Todo> todos = todoService.findTodos();
    model.addAttribute("todos" , todos);
    return "todoList";
  }

  @GetMapping("todo/{id}")
  public String ccc(@PathVariable Long id , Model model){
    Todo todo = todoService.findOne(id);
    model.addAttribute("todo" , todo);
    return "todoRead";
  }

  @GetMapping("todo/{id}/modify")
  public String sddfs(@PathVariable Long id , Model model){
    Todo todo = todoService.findOne(id);
    model.addAttribute("todo" , todo);
    return "todoModify";
  }

  @PostMapping("todo/{id}/modify")
  public String scdd(@PathVariable Long id , @ModelAttribute("todo") TodoUpdateDto todoUpdateDto, RedirectAttributes redirectAttributes){
    todoService.update(id , todoUpdateDto);
    redirectAttributes.addAttribute("modifyStatus" , true);
    redirectAttributes.addAttribute("id" , id);
    return "redirect:/todo/list";
  }


  @PostMapping("todo/{id}/remove")
  public String fsdik(@PathVariable Long id , RedirectAttributes redirectAttributes){
    todoService.removeOne(id);
    redirectAttributes.addAttribute("removeStatus" , true);
    redirectAttributes.addAttribute("id" , id);
    return "redirect:/todo/list";
  }

}
