//package com.seecen.springboot_backendmanagement;
//
//import org.junit.jupiter.api.Test;
//
///**
// * @ClassName ThreadLocalTest
// * @Description TODO
// * @Author aql
// * @Date 2024/12/10 上午10:08
// * @Version 1.0
// **/
//public class ThreadLocalTest {
//
//    @Test
//    public void testThreadLocal() {
//        //创建一个ThreadLocal对象
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
//        //开启两个线程，每个线程都要往ThreadLocal中存入一个值
//        new Thread(
//                () -> {
//                    threadLocal.set("张三");
//                    System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
//                    System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
//                    System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
//                },"蓝色").start();
//
//        new Thread(
//                () -> {
//                    threadLocal.set("李四 ");
//                    System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
//                    System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
//                    System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
//                },"绿色").start();
//    }
//}
