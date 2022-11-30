package com.example.todoapp.services;

import com.example.todoapp.Reponsitory.TodoRepository;
import com.example.todoapp.entity.BaseResponse;
import com.example.todoapp.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired TodoRepository repository;
    public BaseResponse createTodo(Todo request){

        BaseResponse baseResponse = new BaseResponse();
        try {
            if(request.getTitle()==""||request.getTitle().isEmpty()){
                baseResponse.setCode(100);
                baseResponse.setMessage("trường title không thể bỏ trống");
            }

        }catch (Exception e){
            baseResponse.setCode(500);
            baseResponse.setMessage("Lỗi serve");
            return baseResponse;
        }
        if(baseResponse.getCode()==1){
            repository.save(request);
        }
        return baseResponse;
    }
    public BaseResponse deletetodo(long id){

        BaseResponse baseResponse = new BaseResponse();
        try {
            Optional<Todo> todo = repository.findById(id);
            if(todo.isPresent()){
               repository.deleteById(id);
            }else {
                baseResponse.setCode(100);
                baseResponse.setMessage("không tìm thấy Id");
            }
        }catch (Exception e){
            baseResponse.setCode(500);
            baseResponse.setMessage("Lỗi serve");
        }
            return baseResponse;
    }
    public BaseResponse update(long id,Todo request){
        BaseResponse baseResponse = new BaseResponse();
        try{
        Todo todo =repository.getReferenceById(id);
            if (todo!=null){
               todo.setTitle(request.getTitle());
               repository.save(todo);
            }
        }catch (Exception e){
            baseResponse.setCode(500);
            baseResponse.setMessage("Lỗi serve");
            return baseResponse;
        }
        return baseResponse;
    }
}
