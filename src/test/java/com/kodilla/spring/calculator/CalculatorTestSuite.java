package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double a = 2.5;
        double b = 1.3;
        //Then
        Assert.assertEquals(a+b, calculator.add(a, b), 0);
        Assert.assertEquals(a-b, calculator.sub(a, b), 0);
        Assert.assertEquals(a*b, calculator.mul(a, b), 0);
        Assert.assertEquals(a/b, calculator.div(a, b), 0);
    }
}
