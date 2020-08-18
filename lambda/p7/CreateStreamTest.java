package com.atguigu.java8.lambda.p7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author jianglinchen
 * @description 创建 Stream
 * @date 2020/7/24 / 14:32
 */
public class CreateStreamTest {

    @Test
    public void test1() {
        // 1. 可以通过 Collection 系列集合提供的 stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 2. 通过 Arrays 中的静态方法 stream() 获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        // 3. 通过 Stream 类中的静态方法 of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 4. 创建无限流
        // 迭代
        // 无效果, 类似方法
        Stream<Integer> iterate4 = Stream.iterate(0, (x) -> x + 2);
        // 终止操作( 调用 )
        iterate4.limit(10)
                // 输出
                .forEach(System.out::println);

        // 生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }

}
