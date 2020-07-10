package com.atguigu.java8.lambda.p2understanding.employee.a2anonymous;

/**
 * @author jianglinchen
 * @description 策略模式
 * @date 2020/7/9 / 11:06
 */
@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}