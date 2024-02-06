package com.demo.service;

import com.demo.Repository.TaskRepo;
import com.demo.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskRepo taskRepo;

    public List<Task> findAllTasks() {
        try {
            return taskRepo.findAll();
        } catch (Exception e) {
            logger.error("Error in finding all tasks");
            throw e;
        }
    }

    public Optional<Task> findById(int id) {
        try {
            return taskRepo.findById(id);
        }catch(Exception e){
            logger.error("Error in finding the task");
            throw e;
        }
    }

    public Task saveTask(Task task) {
        try {
            return taskRepo.save(task);
        }catch(Exception e){
            logger.error("Error task saving");
            throw e;
        }
    }

    public Task updateTask(Task task) {
        try {
            return taskRepo.save(task);
        }catch(Exception e){
            logger.error("Error in task updating");
            throw e;
        }
    }

    public void deleteTask(int id) {
        try {
            taskRepo.deleteById(id);
        }catch(Exception e){
            logger.error("Error in task deletion");
            throw e;
        }
    }
}
