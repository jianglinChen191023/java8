package com.atguigu.java8.lambda.p5;

import org.junit.Test;

import java.util.function.BiConsumer;

/**
 * @author jianglinchen
 * @description 消费性接口
 * <p>
 * Consumer<T> : 消费型接口
 * - void accept(T t);
 * </p>
 * @date 2020/7/20 / 15:22
 */
public class ConsumerTest {

    /**
     * Consumer<T> 消费性接口
     */
    @Test
    public void test1() {
        happy(10000, m -> System.out.println("买一台电脑消费 " + m + " 元"));
        happy(10000, 200, (m1, m2) -> System.out.println("买一台电脑消费 " + m1 + m2 + " 元"));
    }

    /**
     * @param money
     * @param con   Consumer<T> 消费性接口
     *              void accept(T t);
     */
    public void happy(double money, java.util.function.Consumer<Double> con) {
        con.accept(money);
    }

    /**
     * @param money1
     * @param money2
     * @param con    BiConsumer<T,U> 消费性接口
     *               void accept(T t, U u);
     */
    public void happy(double money1, double money2, BiConsumer<Double, Double> con) {
        con.accept(money1, money2);
    }

}

