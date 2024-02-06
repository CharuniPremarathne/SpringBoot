package com.demo.controller;

import com.demo.entity.Task;
import com.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> findAllTasks(){
        return taskService.findAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> findTaskById(@PathVariable("id") int id){
        return taskService.findById(id);
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @PutMapping("/updateTask")
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") int id){
        taskService.deleteTask(id);
    }
}
