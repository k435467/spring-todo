package ethan.SpringTodo.services;

import ethan.SpringTodo.model.Todo;
import ethan.SpringTodo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService implements ITodoService{

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public Todo insert(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Long id, Todo todo) {
        Todo todoOg = todoRepository.findById(id).get();
        todoOg.setTodoStatus(todo.getTodoStatus());
        todoOg.setDescription(todo.getDescription());
        todoOg.setTitle(todo.getTitle());
        todoRepository.save(todoOg);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

}
