package com.demo.service;

import com.demo.Repository.TaskRepo;
import com.demo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public List<Task> findAllTasks(){
        return taskRepo.findAll();
    }

    public Optional<Task> findById(int id){
        return taskRepo.findById(id);
    }

    public Task saveTask(Task task){
        return taskRepo.save(task);
    }

    public Task updateTask(Task task){
        return taskRepo.save(task);
    }

    public void deleteTask(int id){
        taskRepo.deleteById(id);
    }
}
