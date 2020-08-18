package com.atguigu.java8.lambda.p6;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author jianglinchen
 * @description 方法引用: 若 Lambda 体中的内容有方法已经实现了, 我们可以使用"方法引用"
 * - (可以理解为方法引用是 Lambda 表达式的另外一种表现形式)
 * <p>
 * 主要有三种语法格式:
 * 1. 对象::实例方法名 System.out(对象)::print(实例方法名)
 * 2. 类::静态方法名
 * 3. 类::实例方法名
 * <p>
 * 注意:
 * - Lambda 体中调用方法的参数列表与返回值类型, 要与函数式接口中抽象方法的参数列表和返回值类型一致
 * - 若 Lambda 参数列表中的第一参数是 实例方法的调用者, 而第二个参数是实例方法的参数时, 可以使用 ClassName::method
 * @date 2020/7/20 / 16:26
 */
public class MethodRefTest {

    /**
     * 类::实例方法
     */
    @Test
    public void test4() {
        // 比较字符串
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp.test("123", "123"));
        System.out.println(bp2.test("123", "123"));
    }

    /**
     * 类::静态方法
     */
    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> com2 = Integer::compare;

        System.out.println(com.compare(4, 5));
        System.out.println(com2.compare(4, 4));
    }

    //region 对象名::实例名
    @Test
    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);
        // 参数类型与返回值必须一致
        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;

        con.accept("1");
        con1.accept("2");
        con2.accept("3");
    }


    @Test
    public void test2() {
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String s = sup.get();
        System.out.println(s);

        Supplier<Integer> sup2 = emp::getAge;
        Integer integer = sup2.get();
        System.out.println(integer);
    }
    //endregion
}
