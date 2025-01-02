//package com.seecen.springboot_backendmanagement;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//
//import javax.annotation.Resource;
//import java.util.concurrent.TimeUnit;
//
///**
// * @ClassName RedisTest
// * @Description TODO
// * @Author aql
// * @Date 2025/1/2 12:01
// * @Version 1.0
// **/
////如果在测试类上添加了这个注解，那么将来单元测试方法执行之前，会先初始化Spring容器
//@SpringBootTest
//public class RedisTest {
//
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Test
//    void testSet(){
//        //往redis当中存储一个键值对 StringRedisTemplate
//        ValueOperations<String, String> Operations = stringRedisTemplate.opsForValue();
//
//        Operations.set("key1", "value1",15, TimeUnit.SECONDS);
//    }
//
//    @Test
//    void testGet(){
//        ValueOperations<String, String> Operations = stringRedisTemplate.opsForValue();
//        String value = Operations.get("key1");
//        System.out.println(value);
//    }
//}
