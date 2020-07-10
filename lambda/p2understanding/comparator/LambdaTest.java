package com.atguigu.java8.lambda.p2understanding.comparator;

import org.junit.Test;

import java.util.*;

/**
 * @author jianglinchen
 * @description 认识 Lambda
 * @date 2020/7/9 / 10:34
 */
public class LambdaTest {

    /**
     * 原来的匿名内部类
     */
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet ts = new TreeSet<>(com);
    }

    /**
     * Lambda 优化 Comparator
     */
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet ts = new TreeSet<>(com);
    }

    /**
     * 语法糖
     */
    @Test
    public void test3() {
        Comparator<Integer> com = Integer::compare;
        TreeSet ts = new TreeSet<>(com);
    }

}