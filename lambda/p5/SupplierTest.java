package com.atguigu.java8.lambda.p5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author jianglinchen
 * @description 供给型接口
 * <p>
 * 2. Supplier<T> : 供给型接口
 * - T get();
 * </p>
 * @date 2020/7/20 / 15:23
 */
public class SupplierTest {

    /**
     * Supplier<T> 供给型接口
     */
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        numList.forEach(System.out::println);
    }

    /**
     * 需求: 产生指定个数的整数, 并放入集合中
     */
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }

        return list;
    }
}
