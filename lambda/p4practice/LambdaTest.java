package com.atguigu.java8.lambda.p4practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jianglinchen
 * @description Lambda 练习题
 * @date 2020/7/9 / 15:23
 */
public class LambdaTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 68, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    /**
     * 练习1:
     * 调用 Collections.sort() 方法, 通过定制排序比较两个 Employee
     * 先按年龄比, 年龄相同按姓名比
     * 使用 Lambda 作为参数传递
     */
    @Test
    public void test1() {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        employees.forEach(System.out::println);
    }

    /**
     * 练习二:
     * 1. 声明函数式接口, 接口中声明抽象方法, public String getValue(String str)
     * 2. 声明类 LambdaTest, 类中编写方法使用接口作为参数, 将一个字符串转换成大写, 并作为方法的返回值
     * 3. 在将一个字符串的第2个和第4个索引位置进行截取字符串
     */
    @Test
    public void test2() {
        System.out.println(strHandler("hello World!", str -> str.substring(0, 1).toUpperCase() + str.substring(1)));

        System.out.println(strHandler("hello World!", str -> str.substring(2, 5)));
    }

    public String strHandler(String str, MyFunction2 myPredicate) {
        return myPredicate.getValue(str);
    }

    /**
     * 练习3:
     * 1. 声明一个带两个泛型的函数式接口, 泛型类型为<T,R> T为参数, R为返回值
     * 2. 接口中声明对应的抽象方法
     * 3. 在 LambdaTest 类中声明方法, 使用接口作为参数, 计算两个 long 型参数的和
     * 4. 再计算两个 long 型参数的乘积
     */
    @Test
    public void test3() {
        op(100L, 200L, (t1, t2) -> t1 + t2);
        op(100L, 200L, (t1, t2) -> t1 * t2);
    }

    public void op(Long l1, Long l2, MyFunction3<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }
}
