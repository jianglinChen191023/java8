package com.atguigu.java8.lambda.p8;

import com.atguigu.java8.lambda.p2.employee.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author jianglinchen
 * @description 筛选与切片
 * @date 2020/7/24 / 15:32
 */
public class StreamTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    /**
     * 筛选与切片:
     * 方法  |描述
     * -------- | -----
     * filter(Predicate p) | 接受 Lambda, 从流中排除某些元素
     * distinct | 筛选, 通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     * limit(long maxSize) | 截断流, 使其元素不超过给定数量
     * skip(long n) | 跳过元素, 返回一个扔掉了前 n 个元素的流, 若流中元素不足 n 个, 则返回一个空流。 与 limit(n) 互补
     */

    // 内部迭代: 迭代操作由 Stream API 完成
    @Test
    public void test1() {
        Stream<Employee> stream = employees
                // 创建流
                .stream()
                // 中间操作, 过滤
                .filter((x) -> {
                    System.out.println("Stream API 的中间操作");
                    return x.getAge() > 35;
                });

        // 终止操作: 一次性执行全部内容, 即 '惰性求值'
        stream.forEach(System.out::println);
    }

}
