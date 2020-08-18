## P8_尚硅谷_JAVA8新特性_Stream_筛选与切片
方法  |描述
-------- | -----
filter(Predicate p) | 接受 Lambda, 从流中排除某些元素
distinct | 筛选, 通过流所生成元素的 hashCode() 和 equals() 去除重复元素
limit(long maxSize) | 截断流, 使其元素不超过给定数量
skip(long n) | 跳过元素, 返回一个扔掉了前 n 个元素的流, 若流中元素不足 n 个, 则返回一个空流。 与 limit(n) 互补
