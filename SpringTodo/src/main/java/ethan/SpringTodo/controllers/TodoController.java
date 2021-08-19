package ethan.SpringTodo.controllers;

import ethan.SpringTodo.model.Todo;
import ethan.SpringTodo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {
        return new ResponseEntity<>(todoService.getTodoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        Todo todo1 = todoService.insert(todo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("todo", "/api/todo/" + todo1.getId().toString());
        return new ResponseEntity<>(todo1, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        todoService.updateTodo(id, todo);
        return new ResponseEntity<>(todoService.getTodoById(id), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Todo> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
