package ru.gb.example3_sem3_hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;

@Service
public class UserService {

    @Autowired
    private NotificationService notificationService;

    public User createUser(String name, int age, String email) {
        User user = new User(name, age, email);
        notificationService.notifyUser(user);
        return user;
    }
}
