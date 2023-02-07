package com.esther.activitytracker.controller;

import com.esther.activitytracker.model.User;
import com.esther.activitytracker.payload.LoginDto;
import com.esther.activitytracker.payload.TaskDto;
import com.esther.activitytracker.payload.UserDto;
import com.esther.activitytracker.repository.UserRepository;
import com.esther.activitytracker.service.TaskService;
import com.esther.activitytracker.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tracker")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping ("sign-up")
    public String createUser(Model model, UserDto userDto){
        model.addAttribute("userDto", userDto);
        return "signup";
    }

    @PostMapping("sign-user")
    public String saveUser(@ModelAttribute UserDto userDto){
        userService.createNewUser(userDto);
        return "redirect:/tracker/log-in";
    }

    @GetMapping("log-in")
    public String acceptUser(Model model, LoginDto loginDto){
        model.addAttribute("loginDto", loginDto);
        return "login";
    }

    @PostMapping("login-user")
    public String login(@ModelAttribute LoginDto loginDto , HttpSession session){
        userService.loginAUser(loginDto);
        User user = userRepository.findByEmail(loginDto.getEmail()).get();
        session.setAttribute("id" , user.getId());
        return "redirect:/tracker/home-page";
    }

    @GetMapping("home-page")
    public String Track(Model model, TaskDto taskDto){
        model.addAttribute("tasks", taskService.getAllTask());
       // model.addAttribute("allTasks" , )
        return "homepage";
    }






}
