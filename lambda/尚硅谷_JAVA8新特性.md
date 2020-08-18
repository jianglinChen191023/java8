# JAVA8 新特性
## 一. 简介
## 二. 为什么使用 Lambda 表达式
## 三. Lambda 基础语法
## 四. Lambda 练习
## 五. 四大内置核心函数式接口
函数接口 | 方法 
-------- | -----
Consumer<T> : 消费型接口 | void accept(T t); 
Supplier<T> : 供给型接口 | T get();
Function<T,R> : 函数型接口 | R apply(T t)
Predicate<T> : 断言型接口 | boolean test(T t)

### 5.1 其他接口
函数接口 | 方法 
-------- | -----
BiFunction<T, U, R> 函数接口 | R apply(T t, U u)
UnaryOperator<T>(Function子接口) | T apply<T t>
BinaryOperator<T>(BiFunction子接口) | T apply<T t1, T t2>
BiConsumer<T,U> | void accep<T t, U u>
ToIntFunction<T>,ToLongFunction<T>,ToDoubleFunction<T> | int/long/double applyAsint/applyAslong/applyAsdouble(T t)
IntFunction<R>,LongFunction<R>,DoubleFunction<R> | R apply(int/long/double value)

## 六、P6_方法引用与构造器引用
### 6.1 方法引用
方法引用: 若 Lambda 体中的内容有方法已经实现了, 我们可以使用"方法引用"
   - (可以理解为方法引用是 Lambda 表达式的另外一种表现形式)
#### 6.1.1 主要有三种语法格式:  
1. 对象::实例方法名
  - System.out(对象)::print(实例方法名)
     
2. 类::静态方法名
3. 类::实例方法名
#### 6.1.2 注意
- Lambda 体中调用方法的参数列表与返回值类型, 要与函数式接口中抽象方法的参数列表和返回值类型一致
- 若 Lambda 参数列表中的第一参数是 实例方法的调用者, 而第二个参数是实例方法的参数时, 可以使用 ClassName::method

### 6.2 构造器引用
#### 6.2.1 格式:
ClassName::new
#### 6.2.2 注意: 
- 需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致!

## 七-十三. Stream 的三个操作步骤
1. 创建 Stream
2. 中间操作
3. 终止操作( 终端操作 )
### 713.1 创建 Stream
### 713.2中间操作
        多个`中间操作`可以连接起来形成一个`流水线`,
        除非流水线上触发终止操作,否则中间操作不会执行任何的处理
        而在终止操作时一次性全部处理, 称为 `惰性求值`
        
            -- 设置行为, 等待调用(终止操作)
#### 713.2.1 筛选与切片
方法  |描述
-------- | -----
filter(Predicate p) | 接受 Lambda, 从流中排除某些元素
distinct | 筛选, 通过流所生成元素的 hashCode() 和 equals() 去除重复元素
limit(long maxSize) | 截断流, 使其元素不超过给定数量
skip(long n) | 跳过元素, 返回一个扔掉了前 n 个元素的流, 若流中元素不足 n 个, 则返回一个空流。 与 limit(n) 互补
#### 713.2.2 映射
方法  | 描述
-------- | -----
map(Function f) | 接受一个函数作为参数, 该函数会被应用到每个元素上, 并将其映射成一个新的元素
mapToDouble(ToDoubleFunction f) | 接受一个函数作为参数, 该函数会被应用到每个元素上, 产生一个新的 DoubleStream
mapToInt(ToIntFunction f) | 接受一个函数为参数, 该函数会被应用到每个元素上, 产生一个新的 IntStream
mapToLong(ToLongFunction f) | 接受一个函数作为参数, 该函数会被应用到每个元素中上, 产生一个新的 LongStream
flatMap<Function f> | 接受一个函数作为参数, 将流中的每个值都换为另一个流, 然后把所有流连接成一个流
#### 713.2.3 排序
方法  | 描述
-------- | -----
sorted() | 产生一个新流, 其中按自然顺序排序
sorted(Comparator comp) | 产生一个新流, 其中按比较器顺序排序

### 713.3终止操作( 终端操作 )
终止操作: 一次性执行全部内容, 即 '惰性求值'
        
        stream.forEach(System.out::println);
## 七_创建stream
 ```java
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
 ```

## 八. Stream 筛选与切片 (Stream 中间操作)
方法  |描述
-------- | -----
filter(Predicate p) | 接受 Lambda, 从流中排除某些元素
distinct | 筛选, 通过流所生成元素的 hashCode() 和 equals() 去除重复元素
limit(long maxSize) | 截断流, 使其元素不超过给定数量
skip(long n) | 跳过元素, 返回一个扔掉了前 n 个元素的流, 若流中元素不足 n 个, 则返回一个空流。 与 limit(n) 互补

## 九. Stream 映射(Stream 中间操作)
方法  | 描述
-------- | -----
map(Function f) | 接受一个函数作为参数, 该函数会被应用到每个元素上, 并将其映射成一个新的元素
mapToDouble(ToDoubleFunction f) | 接受一个函数作为参数, 该函数会被应用到每个元素上, 产生一个新的 DoubleStream
mapToInt(ToIntFunction f) | 接受一个函数为参数, 该函数会被应用到每个元素上, 产生一个新的 IntStream
mapToLong(ToLongFunction f) | 接受一个函数作为参数, 该函数会被应用到每个元素中上, 产生一个新的 LongStream
flatMap<Function f> | 接受一个函数作为参数, 将流中的每个值都换为另一个流, 然后把所有流连接成一个流

## 十. Stream 排序(Stream 中间操作)
方法  | 描述
-------- | -----
sorted() | 产生一个新流, 其中按自然顺序排序
sorted(Comparator comp) | 产生一个新流, 其中按比较器顺序排序

## 十一. Stream 查找与匹配(Stream 中间操作)


## 十二. Stream Stream 归约与收集(Stream 中间操作)

## 十三. Stream API 练习 

## 十四. 并行流与串行流
## 十五. Optional 容器类
## 十六. 接口中的默认方法与静态方法
## 十七. 传统时间格式化的线程安全问题
## 十八. 新时间与日期 API-本地时间与时间戳
## 十九. 新时间与日期 API-时间校正器
## 二十. 新时间与日期 API-时间格式化与时区处理
## 二十一. 重复注解与类型注解