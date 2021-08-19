package ethan.SpringTodo.services;

import ethan.SpringTodo.model.Todo;

import java.util.List;

public interface ITodoService {
    List<Todo> getTodos();

    Todo getTodoById(Long id);

    Todo insert(Todo todo);

    void updateTodo(Long id, Todo todo);

    void deleteTodo(Long id);
}
