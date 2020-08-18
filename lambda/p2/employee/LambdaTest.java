package com.atguigu.java8.lambda.p2.employee;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianglinchen
 * @description 认识 Lambda
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

    /**
     * 需求1: 获取当前公司中员工年龄大于等于 35 的员工信息
     */
    public List<Employee> filterEmployees(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }

        return emps;
    }

    /**
     * 需求2: 获取当前公司中员工工资大于等于 5000 的员工信息
     */
    public List<Employee> filterEmployees2(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : list) {
            if (emp.getSalary() >= 5000) {
                emps.add(emp);
            }
        }

        return emps;
    }

    @Test
    public void test1() {
        List<Employee> list = filterEmployees(this.employees);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void test2() {
        List<Employee> list = filterEmployees2(this.employees);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}
