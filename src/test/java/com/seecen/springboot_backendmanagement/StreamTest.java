//package com.seecen.springboot_backendmanagement;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.function.Supplier;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
///**
// * @ClassName StreamTest
// * @Description TODO
// * @Author aql
// * @Date 2024/12/23 17:04
// * @Version 1.0
// **/
//public class StreamTest {
//
//    @Test
//    public void testStream() {
//        List<String> list1 = new ArrayList<>();
//
//        list1.add("张老三");
//        list1.add("张小三");
//        list1.add("李四");
//        list1.add("赵五");
//        list1.add("张六");
//        list1.add("王八");
//
//        ArrayList<String> list2 = new ArrayList<>();
//        //放入到一个新的集合当中
//        for (String name : list1) {
//            if(name.startsWith("张")){
//                list2.add(name);
//            }
//        }
//
//        ArrayList<Object> list3 = new ArrayList<>();
//        for (String name : list2) {
//            if (name.length()==3){
//                list3.add(name);
//            }
//        }
//        System.out.println(list3);
//
//    }
//
//    @Test
//    public void testStream2() {
//        List<String> list1 = new ArrayList<>();
////        list1.stream().filter((String name)->name.startsWith("张")).filter((String name)-> name.length()==3).forEach(System.out::println);
////        System.out.println(list1);
//
//        list1.stream().filter((String name)->name.startsWith("张")).filter((String name)->name.length()==3).forEach((String name)->{
//            System.out.println("符合条件的姓名：" + name);
//        });
//    }
//
//    @Test
//    public void testStream3() {
//        List<String> list1 = new ArrayList<>();
//        list1.add("1");
//        list1.add("2");
//        System.out.println(list1);
//        List<String> list = Arrays.asList("hello", "world");
//        //asList是不能添加，或删除的
//        list.add(0, "hello");
//        System.out.println(list);
//    }
//
//    @Test
//    public void testStream4() {
//        List<String> list = Arrays.asList("a", "b", "c");
//        //创建一个顺序流
//        Stream<String> stream =  list.stream();
//        //创建一个并行流
//        Stream<String> paralleStream = list.parallelStream();
//        //Stream流只能被调用一次，当调用一次之后，就会关闭
////        System.out.println(stream.count());
//        System.out.println(stream.collect(Collectors.toList()));
//        System.out.println(paralleStream.collect(Collectors.toList()));
//
//    }
//
//    @Test
//    public void testStream5() {
//        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
//        Stream<Integer> stream = list.stream();
//        stream.filter(x-> x > 7).forEach(System.out::println);
//
//    }
//
//
//    @Test
//    public void testStream6() {
//        List<Person> personList = new ArrayList<Person>();
//        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
//        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
//        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
//        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
//        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
//        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
//
//
//        List<String> stream = personList.stream().filter(person -> person.getAge()>=18 && person.getSalary() >8200).map(Person::getName)
//                .collect(Collectors.toList());
//
//        System.out.println(stream);
//    }
//
//    @Test
//    public void testLambda() {
//        List<String> list = Arrays.asList("Alice", "Bob", "Charlie");
//        list.forEach(name -> System.out.println(name));
////        list.forEach(System.out::println);
//
//    }
////    @Test
////    public void testLambda2() {
////        int x = 10;
////        Myfunction myfunction = y -> System.out.println( x + y);
////        myfunction.doSomething(5);
////
////    }
//
//
//    @Test
//    public void testIO() throws IOException {
//        char c;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("输入字符, 按下 'q' 键退出。");
//        // 读取字符串
//        do{
//            c = (char)br.read();
//            System.out.println(c);
//        }while (c != 'q');
//
//    }
//
//    @Test
//    public void testIO2() throws IOException {
//        int count = 0;
//        do{
//            System.out.println(count);
//            count++;
//        }while (count < 2);
//    }
//
//    @Test
//    public void testStream7(){
//        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
//        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
//        System.out.println(max.get());
//    }
//
//    @Test
//    public void testSupplier(){
//        Supplier<Double> randomNumberSupplier = Math::random;
//
//        Double v = randomNumberSupplier.get();
//        System.out.println(v);
//
//    }
//
//    @Test
//    public void test01(){
//        Person[] rosterAsArray = new Person[30];
//        class PersonAgeComparator implements Comparator<Person> {
//
//            @Override
//            public int compare(Person a, Person b) {
//                return a.getAge() - b.getAge();
//            }
//        }
//    }
//
//    @Test
//    public void testStream8(){
//        //获取Integer集合中的最大值。
//        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
//        Optional<Integer> max = list.stream().max((a,b)-> a-b);
//        System.out.println(max.get());
//    }
//
//    @Test
//    public void testStream9(){
//        //计算Integer集合中大于6的元素的个数。
//        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
//        Long count = list.stream().filter(x -> x > 6).count();
//        System.out.println(count);
//        }
//
//    @Test
//    public void testStream10(){
//        //英文字符串数组的元素全部改为大写。整数数组每个元素+3
//            String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
//            List<String> collect = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
//            collect.forEach(System.out::println);
//
//            List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
//            List<Integer> collect1 = intList.stream().map(x -> x + 3).collect(Collectors.toList());
//            collect1.forEach(System.out::println);
//        }
//
//        @Test
//        public void testStream11(){
//        //将员工的薪资全部增加1000。
//            List<Person> personList = new ArrayList<Person>();
//            personList.add(new Person("Tom", 8900, 23, "male", "New York"));
//            personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
//            personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
//            personList.add(new Person("Anni", 8200, 24, "female", "New York"));
//            personList.add(new Person("Owen", 9500, 25, "male", "New York"));
//            personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
//            List<Person> personListNew=personList.stream().map(person -> {
//                Person personNew = new Person(person.getName(), 0, 0, null, null);
//                personNew.setSalary(person.getSalary()+1000);
//                return personNew;
//            }).collect(Collectors.toList());
//            System.out.println("一次改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
//            System.out.println("一次改动后：" + personListNew.get(0).getName() + "-->" + personListNew.get(0).getSalary());
//        }
//
//        @Test
//        public void testStream12() {
//            ArrayList<String> list = new ArrayList<>();
//            list.add("张无忌");
//            list.add("赵敏");
//            list.add("张强");
//            list.add("李三光");
//            list.add("欧阳铁蛋");
//            list.stream().filter(name -> name.startsWith("张")).forEach(System.out::println);
//            System.out.println("----------");
//            list.stream().filter(name -> name.startsWith("张")&& name.length()==3).forEach(System.out::println);
//
//        }
//    }
//
