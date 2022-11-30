package com.example.todoapp.controller;

import com.example.todoapp.Reponsitory.TodoRepository;
import com.example.todoapp.entity.BaseResponse;
import com.example.todoapp.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.todoapp.services.TodoService;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController extends BaseController{
    @Autowired
    TodoService todoServie;
    @Autowired
    TodoRepository repository;
    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody Todo request) {
        return createdResponse(todoServie.createTodo(request));
    }
    @GetMapping
    public Object getall() {
        List<Todo>sad =repository.findAll();
        if(sad.isEmpty()){
            BaseResponse  base = new BaseResponse();
            base.setMessage("không thìm thấy phần tử");
            base.setCode(100);
            return base;
        }
        return sad;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable long id) {
        return createdResponse(todoServie.deletetodo(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse>update(@PathVariable long id,@RequestBody Todo todo){
        return createdResponse(todoServie.update(id,todo));
    }
}
