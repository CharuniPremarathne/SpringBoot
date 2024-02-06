package com.demo.controller;

import com.demo.entity.Task;
import com.demo.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> findAllTasks() {
        try {
            return taskService.findAllTasks();
        }catch(Exception e){
            logger.error("Error in printing task details");
            throw e;
        }
    }

    @GetMapping("/{id}")
    public Optional<Task> findTaskById(@PathVariable("id") int id) {
        try {
            return taskService.findById(id);
        } catch (Exception e) {
            logger.error("Can not print task details");
            throw e;
        }
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task) {
        try {
            return taskService.saveTask(task);
        } catch (Exception e) {
            logger.error("Please check the values");
            throw e;
        }
    }

    @PutMapping("/updateTask")
    public Task updateTask(@RequestBody Task task) {
        try {
            return taskService.updateTask(task);
        }catch(Exception e){
            logger.error("Update not succeed");
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") int id) {
        try {
            taskService.deleteTask(id);
        }catch(Exception e){
            logger.error("Delete not succeed");
        }
    }
}
