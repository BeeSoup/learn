package com.zhangyu.concurrency.learn.immutable;

/**
 * ThreadLocal 结合一个filter 将数据保存到ThreadLocal里面
 *
 * 每一个请求都是一个线程
 * 存储用户信息，然后在后续处理中，直接从ThreadLocal里面取值， 一般信息存放于HttpServletRequest 里面，后续如果取出，
 * 需要带这个参数，没有必要
 *
 * destroy 方法remove，防止内存溢出
 * final 写在static 前面
 */
public class ThreadLocalDemo {
}
