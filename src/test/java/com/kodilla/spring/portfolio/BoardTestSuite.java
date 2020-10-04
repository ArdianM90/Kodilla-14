package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class BoardTestSuite {
    @Test
    public void testContext() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BoardConfig.class);
        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        boolean toDoListExist = context.containsBean("toDoList");
        boolean inProgressListExist = context.containsBean("inProgressList");
        boolean doneListExist = context.containsBean("doneList");
        //Then
        Assert.assertTrue(toDoListExist && inProgressListExist && doneListExist);
    }

    @Test
    public void testAllTasksAreReadable() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.addTaskToDo("Task to do");
        board.addTaskInProgress("Task in progress");
        board.addTaskDone("Task done");
        boolean taskToDoIsReadable = board.readTaskToDo(board.getToDoQuantity()-1).trim().length() > 0;
        boolean taskInProgressIsReadable = board.readTaskInProgress(board.getInProgressQuantity()-1).trim().length() > 0;
        boolean taskDoneIsReadable = board.readTaskDone(board.getDoneQuantity()-1).trim().length() > 0;
        //Then
        Assert.assertTrue(taskToDoIsReadable && taskInProgressIsReadable && taskDoneIsReadable);
    }
}
