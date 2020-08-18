package com.atguigu.java8.lambda.p2.employee.a4stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author jianglinchen
 * @description 使用 Stream API 优化
 * @date 2020/7/9 / 11:30
 */
public class LambdaTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    @Test
    public void test() {
        employees.stream()
                .filter((e) -> e.getSalary() >= 5000)
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
