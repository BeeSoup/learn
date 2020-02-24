package com.zhangyu.concurrency.learn.immutable.commonunsafe;

/**
 * StringBuffer -> safe             |   StringBuilder ->unsafe
 * JodaTime(DateTimeFormatter)      |   SimpleDateFormat
 * JUC                              |   基础集合
 * 普通的线程封闭，非static 全部变量    |   static 全局变量，多线程使用的时候
 *
 * //线程不安全
 * if（condition(a)） {
 *     handle(a)
 * }
 */
public class Demo {
}
