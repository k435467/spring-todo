package ethan.SpringTodo.bootstrap;

import ethan.SpringTodo.model.Todo;
import ethan.SpringTodo.model.TodoStatus;
import ethan.SpringTodo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoLoader implements CommandLineRunner {

    private final TodoService todoService;

    @Autowired
    public TodoLoader(TodoService todoService) {
        this.todoService = todoService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadTodos();
    }

    private void loadTodos() {
        todoService.insert(
                Todo.builder()
                        .title("Go to market")
                        .description("Buy eggs from market")
                        .todoStatus(TodoStatus.NOT_COMPLETED)
                        .build()
        );
        todoService.insert(
                Todo.builder()
                        .title("Go to school")
                        .description("Complete assignments")
                        .todoStatus(TodoStatus.NOT_COMPLETED)
                        .build()
        );
        System.out.println("Sample Todos Loaded.");
    }
}
