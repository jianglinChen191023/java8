package com.atguigu.java8.lambda.p6;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author jianglinchen
 * @description 构造器引用
 * <p>
 * 格式:
 * ClassName::new
 * 注意: 需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致!
 *
 * </p>
 * @date 2020/7/20 / 17:27
 */
public class ConstructorRefTest {

    @Test
    public void test5() {
        Supplier<Employee> sup = () -> new Employee();

        // 构造器引用方式
        Supplier<Employee> sup2 = Employee::new;
        Employee employee = sup2.get();
        System.out.println(employee);
    }

    @Test
    public void test6() {
        Function<Integer, Employee> fun = (x) -> new Employee(x);
        Function<Integer, Employee> fun2 = Employee::new;
        System.out.println(fun.apply(288));
        System.out.println(fun2.apply(288));

        BiFunction<Integer, Integer, Employee> bf = Employee::new;
        System.out.println(bf.apply(1, 288));
    }

}
