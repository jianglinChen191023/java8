## 六、P6_尚硅谷_JAVA8新特性_方法引用与构造器引用
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





