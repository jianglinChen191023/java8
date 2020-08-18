package com.atguigu.java8.lambda.p8;

/**
 * @author jianglinchen
 * @description 员工信息 实体类
 * @date 2020/7/9 / 11:07
 */
public class Employee {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private Integer age;
    private Double salary;

    public Employee() {
    }

    public Employee(Integer age) {
        this.age = age;
    }

    public Employee(Integer id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
