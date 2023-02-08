package com.esther.activitytracker.service;

import com.esther.activitytracker.model.Task;
import com.esther.activitytracker.model.User;
import com.esther.activitytracker.payload.TaskDto;
import com.esther.activitytracker.repository.TaskRepository;
import com.esther.activitytracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;


    public Task addTask(TaskDto taskDto, Long id){
        User user  = userRepository.findById(id).get();
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription((taskDto.getDescription()));
        task.setStatus(taskDto.getStatus());
        task.setUser(user);
        return taskRepository.save(task);
    }
    public Task getById(Long id){
        return taskRepository.findById(id).get();
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }



    public Task updateTask(Task taskDto){
        return taskRepository.save(taskDto);
    }

}
