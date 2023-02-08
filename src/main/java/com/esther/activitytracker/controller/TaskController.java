package com.esther.activitytracker.controller;

import com.esther.activitytracker.model.Task;
import com.esther.activitytracker.payload.LoginDto;
import com.esther.activitytracker.payload.TaskDto;
import com.esther.activitytracker.repository.TaskRepository;
import com.esther.activitytracker.service.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("add-task")
    public String listAllTask(Model model){
        model.addAttribute("addTask", taskService.getAllTask());
        return "add_task";
    }

    @PostMapping("add-new-task")
    public String createTask(@ModelAttribute TaskDto taskDto, HttpSession session){
        Long id = (Long) session.getAttribute("id");
        taskService.addTask(taskDto, id);
       // model.addAttribute("newTask", taskService.addTask(new TaskDto(), id));
        return "redirect:/tracker/home-page";

    }

    @GetMapping("edit{id}")
    public String editTask(@PathVariable Long id, Model model){
        model.addAttribute("edit", taskService.getById(id));
        return "edit_task";
    }

    @PostMapping("{id}")
    public String updateEditedTask(@PathVariable Long id, @ModelAttribute("edits") TaskDto taskDto){
        Task existingTask = taskService.getById(id);

        existingTask.setTitle(taskDto.getTitle());
        existingTask.setDescription((taskDto.getDescription()));
        existingTask.setStatus(taskDto.getStatus());
        taskService.updateTask(existingTask);
        return "redirect:/tracker/home-page";
    }
}
