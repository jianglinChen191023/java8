package com.atguigu.java8.lambda.p2.employee.a1design;

/**
 * @author jianglinchen
 * @description 判断员工工资是否大于等于 5000
 * @date 2020/7/9 / 14:03
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
