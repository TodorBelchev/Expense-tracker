package com.expense_tracker.api.controller;

import com.expense_tracker.api.model.dto.TestMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-message")
public class TestMessageController {

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public TestMessage getTestMessage() {
        return new TestMessage("Test message title", "Lorem ipsum dolor sit amet...");
    }
}
