## 四大内置核心函数式接口
    1. Consumer<T> : 消费型接口
        - void accept(T t); 
    2. Supplier<T> : 供给型接口
        - T get();
    3. Function<T,R> : 函数型接口
        - R apply(T t)
    4. Predicate<T> : 断言型接口
        - boolean test(T t)
    5. 其他接口
         5.1 BiFunction<T, U, R> 函数接口
            - R apply(T t, U u)
         5.2 UnaryOperator<T>(Function子接口)
            - T apply<T t>
         5.3 BinaryOperator<T>(BiFunction子接口)
            - T apply<T t1, T t2>
         5.4 BiConsumer<T,U>
            - void accep<T t, U u>
         5.5 ToIntFunction<T>
         5.6 ToLongFunction<T>
         5.7 ToDoubleFunction<T>
            - int/long/double applyAsint/applyAslong/applyAsdouble(T t)
         5.8 IntFunction<R>
         5.9 LongFunction<R>
         5.10 DoubleFunction<R>
            - R apply(int/long/double value)
                  