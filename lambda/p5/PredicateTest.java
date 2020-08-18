package com.atguigu.java8.lambda.p5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author jianglinchen
 * @description 断言型接口
 * <p>
 * 4. Predicate<T> : 断言型接口
 * - boolean test(T t)
 * </p>
 * @date 2020/7/20 / 15:39
 */
public class PredicateTest {

    /**
     * Predicate<T> : 断言型接口
     */
    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
        List<String> strings = filterStr(list, (str) -> str.length() > 3);
        strings.forEach(System.out::println);
    }

    /**
     * 需求: 将满足条件的字符串, 放入集合中
     */
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }

        return strList;
    }

}
