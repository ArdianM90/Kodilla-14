package com.kodilla.spring.portfolio;

import com.kodilla.spring.reader.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
//    @Autowired
//    @Qualifier("toDoList")
//    TaskList toDoList;
//    @Autowired
//    @Qualifier("inProgressList")
//    TaskList inProgressList;
//    @Autowired
//    @Qualifier("doneList")
//    TaskList doneList;
    @Autowired
    @Qualifier("newTaskList")
    TaskList newTaskList;

    @Bean
//    public Board createBoard() {
//        return new Board(toDoList, inProgressList, doneList);
//    }
    public Board createBoard() {
        return new Board(newTaskList, newTaskList, newTaskList);
    }
//    @Bean(name = "toDoList")
//    @Scope("prototype")
//    public TaskList getToDoList() {
//        return new TaskList();
//    }
//
//    @Bean(name = "inProgressList")
//    @Scope("prototype")
//    public TaskList getInProgressList() {
//        return new TaskList();
//    }
//
//    @Bean(name = "doneList")
//    @Scope("prototype")
//    public TaskList getDoneList() {
//        return new TaskList();
//    }

    @Bean(name = "newTaskList")
    @Scope("prototype")
    public TaskList getNewTaskList() {
        return new TaskList();
    }
}
