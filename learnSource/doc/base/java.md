## Java ⾯向对象基础
### ⽅法设计

- 单元：一个类或者一组类（组件）
  - 类采用名词结构
    - 动词过去式+名词
      - ContextRefreshedEvent
    - 动词ing + 名词
      - InitializingBean
    - 形容词 + 名词
      - ConfigurableApplicationContext
- 执行：某个方法
  - 方法命名：动词
    - execute
    - callback
    - run
  - 方法参数：名词
  - 异常：
    - 根（顶层）异常
      - Throwable
        - checked 类型：Exception
        - unchecked类型：RuntimeException
        - 不常见：Error
    - Java 1.4 `java.lang.StackTraceElement`
      - 添加异常原因（cause）
        - 反模式：吞掉某个异常
        - 性能：注意 `fillInStackTrace()` 方法的开销，避免异常栈调用深度
          - 方法一：JVM 参数控制栈深度（物理屏蔽）
          - 方法二：logback 日志框架控制堆栈输出深度（逻辑屏蔽）

## 泛型设计

Java 泛型属于编译时处理，运行时擦写。



## Java 函数式设计



### 匿名内置类

基本特性：

- 无名称类
- 声明位置(执行模块)：
  - static block 
  - 实例block 
  - 方法
  - 构造器
- 并非特殊的类结构
  - 类全名称：${package}.${declared_class}.${num}



## 函数式接口

基本特性：

- 所有的函数式接口都引用一段执行代码
- 函数式接口没有固定的类型，固定模式（ SCFP = Supplier + Consumer + Function + Predicate） + Action
- 利用方法引用来实现模式匹配



## 模块化

### 强封装性

基本特性

- 并非所有的 `public` Class 都可以被运用，需要 `exports` 来配合
- `exports` 所配置的 `package` 下必须要有 Class

负面问题

- 对人的要求就高了（对 Class 透明化）
  - 必须了解相关 `module-info.java` 语义
  - 需要了解某些类的依赖
  - 需要了解某些类职责

个人观点

- 收益不大，代价不小
- 对团队要求极高，容易出现互喷的情况
- Java 9 之前采用 jar 文件管理，Java 9 模块化之后，编程了 module-info.java 管理，还需要考虑与 Maven 依赖管理组件如何配合



---  
这是分割线
---

#面试题知识点
##基础知识
> 面向对象三大特点：封装（数据和操作封装成一个类）、继承（）、多态
> static,静态关键字，加载类时，会被分配空间加载，在第一次使用的时候，初始化   
>

##异常处理
> 并非所有的类都能用try-with-resources处理。实现AutoCloseable接口是使用try-with-resources语句的前提。
> 在try-with-resources语句中，只有实现了AutoCloseable接口的类才会被视为资源进行相关处理，否则会出现编译错误。
> try-with-resources语句和AutoCloseable接口
>  Java7为我们提供了一个非常强悍的功能来自动关闭这些资源。“管理”一词在这里燃值颇高，其实它的工作就是关闭资源。资源自动化管理帮助我们自动关闭这些资源。
> Resource instantiation should be done within try(). A parenthesis () is introduced after 
   try statement and the resource instantiation should happen within that paranthesis as below,
   　　资源的初始化工作是在try()中完成的。try后面引入了一对小括号()，用于在其中完成资源的初始化，示例如下：
```$xslt
try (InputStream is = new FileInputStream("test")) {
	is.read();
	...
} catch(Exception e) {
	...
} finally {
	//no need to add code to close InputStream, its close method will be internally called
	//（无需添加关闭InputStream输入流的代码，其close()方法会自行调用）
}
```

> 异常处理的性能成本非常高，每个 Java 程序员在开发时都应牢记这句话。创建一个异常非常慢，抛出一个异常又会消耗1~5ms，当一个异常在应用的多个层级之间传递时，会拖累整个应用的性能。
> 仅在异常情况下使用异常；
  在可恢复的异常情况下使用异常；
  尽管使用异常有利于 Java 开发，但是在应用中最好不要捕获太多的调用栈，因为在很多情况下都不需要打印调用栈就知道哪里出错了。因此，异常消息应该提供恰到好处的信息。
```$xslt
 /**
     * 2021-01-25 10:36:17.156 INFO  MyTest                                            :34   start
     * 2021-01-25 10:36:17.158 INFO  MyTest                                            :41   invoke
     * 2021-01-25 10:36:17.158 INFO  MyTest                                            :42   return
     * 2021-01-25 10:36:17.158 INFO  MyTest                                            :47   finally
     * 2021-01-25 10:36:17.158 INFO  MyTest                                            :36   end
     *
     * @param args
     */
    public static void main(String[] args) {
        log.info("start");
        testTry();
        log.info("end");
    }

    public static void testTry() {
        try {
            log.info("invoke");
            log.info("return");
            return;
        } catch (Exception e) {
            log.info("catch");
        } finally {
            log.info("finally");
        }
    }
```

```$xslt
/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/1/18  zhang  新增
 * ========    =======  ============================================
 */

package com.zhang.learnSource.base;

import lombok.Data;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2021/01/18
 */
@Data
public class Son extends Parent {
    private String sonData;

    private int k;

    public static void main(String[] args) {
        Son son = new Son();
        String data = son.getData();
        son.sys();
    }

    public void sys() {
        int i;
        System.out.println(k); // 正常0
        System.out.println(i); // 编译报错
    }
}
初始值

成员变量：有默认初始值。

局部变量：没有默认初始值，使用前必须赋值。

使用原则

在使用变量时需要遵循的原则为：就近原则
首先在局部范围找，有就使用；接着在成员位置找。



```

##并发知识点
