package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {
    private static String USERNAME;

    public ForumUser() {
        USERNAME = "John Smith";
    }

    public String getUserName() {
        return USERNAME;
    }
}
