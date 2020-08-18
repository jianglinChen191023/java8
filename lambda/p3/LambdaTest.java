package com.atguigu.java8.lambda.p3;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author jianglinchen
 * @description 一、Lambda 表达式的基础语法:
 * java8中引入了一个新的操作符 "->" 该操作符称为 箭头操作符 或 Lambda 操作符
 * <p>
 * 箭头操作符将 Lambda 表达式 拆分成两部分:
 * 左侧: Lambda 表达式的参数列表
 * 右侧: Lambda 表达式中所需执行的功能, 即 Lambda 体
 * </p>
 * <p>
 * 语法格式一: 无参数, 无返回值
 * () -> System.out.println("Hello Lambda!");
 * </p>
 * <p>
 * 语法格式二: 一个参数, 无返回值
 * (o) -> System.out.println(o);
 * 语法格式三: 一个参数, 无返回值( 只有一个参数小括号可以不写 )
 * o -> System.out.println(o);
 * </p>
 * <p>
 * 语法格式四: 有俩个参数以上, 有返回值, 表情 Lambda 体中有多条语句
 * Comparator<Integer> c = (x, y) -> {
 * System.out.println("函数式接口");
 * return Integer.compare(x, y);
 * };
 * 语法格式五: 有俩个参数以上, 有返回值, 表情 Lambda 体中有多条语句( 如果只有一条语句, 大括号和返回值可以省略不写 )
 * Comparator<Integer> c = (x, y) -> Integer.compare(x, y);
 * </p>
 * <p>
 * 语法格式六: Lambda 表达式的参数列表的数据类型可以省略不写, 因为JVM编译器可以通过上下文推断出 数据类型,即"类型推断"( 也是语法糖 )
 * @date 2020/7/9 / 14:32
 */
public class LambdaTest {

    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda");
            }
        };
        r.run();

        Runnable r2 = () -> System.out.println("Hello Lambda!");
        r2.run();
    }

    @Test
    public void test2() {
        Consumer c = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };

        Consumer c2 = o -> System.out.println(o);
        c2.accept("Hello Lambda!");
    }

    @Test
    public void test3() {
        Comparator<Integer> c = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };

        System.out.println(c.compare(10, 10));
    }

    @Test
    public void test4() {
        Comparator<Integer> c = (Integer x, Integer y) -> Integer.compare(x, y);
        System.out.println(c.compare(10, 10));
    }

    @Test
    public void test5() {
        // 类型推断
        String[] strs = {"aaa", "bbb", "ccc"};

        List<String> list = new ArrayList<String>();
        //  List<String> list = new ArrayList<类型推断可以省略不写>();
        List<String> list2 = new ArrayList<>();

        show(new HashMap<>(1));
    }

    public void show(Map<String, Integer> map) {
    }

    /**
     * 需求: 对一个数进行运算
     */
    @Test
    public void test6() {
        MyFun myFun = x -> x * x;
        Integer value = myFun.getValue(100);
        System.out.println(value);

        Integer operation = operation(100, x -> x * x);
        System.out.println(operation);
    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }

}

