package com.atguigu.java8.lambda.p5;

import org.junit.Test;

import java.util.function.*;

/**
 * @author jianglinchen
 * @description 函数型接口
 * <p>
 * 3. Function<T,R> : 函数型接口
 * - R apply(T t)
 * </p>
 * <p>
 * function子接口  UnaryOperator<T>
 * - T apply(T t)
 * </p>
 * @date 2020/7/20 / 15:24
 */
public class FunctionTest {

    //region Function<T,R> 函数型接口

    /**
     * Function<T,R> 函数型接口
     */
    @Test
    public void test3() {
        System.out.println("\t\t\t 范德萨范德萨");
        System.out.println(strHandler("\t\t\t 范德萨范德萨", (str) -> str.trim()));
        System.out.println(strHandler("范德萨范德萨", (str) -> str.substring(0, 3)));
        System.out.println(strHandler("范德萨范德萨", "12312", (str1, str2) -> str1 + str2));
        System.out.println(intHandler(10000, i -> i / 100));
        System.out.println(doubleHandler(11000.00, i -> i / 100));
        System.out.println(longHandler(12000L, i -> i / 100));

        System.out.println(intChange(10000, i -> i + "元"));
    }

    /**
     * 用于处理字符串
     *
     * @param str
     * @param fun
     * @return
     */
//    public String strHandler(String str, Function<String, String> fun) {
//        return fun.apply(str);
//    }
    //endregion

    /**
     * 子接口  UnaryOperator<T>
     *
     * @param str
     * @param fun function子接口  UnaryOperator<T>
     * @return
     */
    public String strHandler(String str, UnaryOperator<String> fun) {
        return fun.apply(str);
    }

    /**
     * 处理2个字符串
     *
     * @param str1
     * @param str2
     * @param fun  BiFunction<T, U, R>
     * @return
     */
    public String strHandler(String str1, String str2, BiFunction<String, String, String> fun) {
        return fun.apply(str1, str2);
    }

    /**
     * 用于处理 整数型
     *
     * @param i
     * @param fun
     * @return
     */
    public Integer intHandler(Integer i, ToIntFunction<Integer> fun) {
        return fun.applyAsInt(i);
    }

    /**
     * 用于处理 浮点型
     *
     * @param i
     * @param fun
     * @return
     */
    public Double doubleHandler(Double i, ToDoubleFunction<Double> fun) {
        return fun.applyAsDouble(i);
    }

    /**
     * 用于处理 长整型
     *
     * @param i
     * @param fun
     * @return
     */
    public Long longHandler(Long i, ToLongFunction<Long> fun) {
        return fun.applyAsLong(i);
    }

    /**
     * 整数型 改为 字符串
     *
     * @param i
     * @param fun
     * @return
     */
    public String intChange(Integer i, IntFunction<String> fun) {
        return fun.apply(i);
    }
}
