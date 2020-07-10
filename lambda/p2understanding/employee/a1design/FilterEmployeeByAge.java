package com.atguigu.java8.lambda.p2understanding.employee.a1design;

/**
 * @author jianglinchen
 * @description 判断年龄是否大于等于 35
 * @date 2020/7/9 / 11:52
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
