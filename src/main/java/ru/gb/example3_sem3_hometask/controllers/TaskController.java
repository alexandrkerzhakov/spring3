package ru.gb.example3_sem3_hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.example3_sem3_hometask.domain.User;
import ru.gb.example3_sem3_hometask.services.DataProcessingService;
import ru.gb.example3_sem3_hometask.services.RegistrationService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        tasks.add("add");
        return tasks;
    }

    @GetMapping("/sort") //localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return dataProcessingService.sortUsersByAge(dataProcessingService.getRepository().getUsers());
    }

    @GetMapping("/filter/{age}") //localhost:8080/tasks/filter/age
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return dataProcessingService.filterUsersByAge(dataProcessingService.getRepository().getUsers(), age);
    }

    @GetMapping("/calc") //localhost:8080/tasks/calc
    public Double calculateAverageAge() {
        return dataProcessingService.calculateAverageAge(dataProcessingService.getRepository().getUsers());
    }

    @GetMapping("/add/{name}/{age}/{email}") //localhost:8080/tasks/add/name/age/email
    public void userAddFromParam(@PathVariable("name") String name, @PathVariable("age") int age, @PathVariable("email") String email) {
        registrationService.processRegistration(name, age, email);
    }

}
