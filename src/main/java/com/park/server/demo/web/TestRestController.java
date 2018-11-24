package com.park.server.demo.web;

import com.park.server.demo.model.Task;
import com.park.server.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestRestController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> listTasks(){
    return taskRepository.findAll();
    }
    @PostMapping("/tasks")
    public Task save(Task t){
return taskRepository.save(t);
    }

}
