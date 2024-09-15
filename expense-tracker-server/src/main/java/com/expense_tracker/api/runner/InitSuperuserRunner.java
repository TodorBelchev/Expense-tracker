package com.expense_tracker.api.runner;

import com.expense_tracker.api.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitSuperuserRunner implements CommandLineRunner {

    private final UserService userService;

    public InitSuperuserRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
       this.userService.registerSuperuser();
    }
}
