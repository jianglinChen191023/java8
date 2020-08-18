package com.atguigu.java8.lambda.p4;

/**
 * @author jianglinchen
 * @description 练习三
 * @date 2020/7/9 / 15:58
 */
@FunctionalInterface
public interface MyFunction3<T, R> {
    R getValue(T t1,T t2);
}
