package cn.xiaotian.basejava;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) {
//        Order order1 = new Order("1101", "2019-11-03 00:30:31", 100);
//        Order order2 = new Order("1102", "2019-11-03 00:30:32", 200);
//        Order order3 = new Order("1103", "2019-11-03 00:30:33", 300);
//        Order order4 = new Order("1104", "2019-11-03 00:30:34", 400);
//        Order order5 = new Order("1105", "2019-11-03 00:30:35", 500);
//        List<Order> orders = new ArrayList<>();
//        orders.add(order2);
//        orders.add(order1);
//        orders.add(order4);
//        orders.add(order3);
//        orders.add(order5);
//
//
//        System.out.println("------------排序前-----------------");
//        for (Order order : orders) {
//            System.out.println("orderNum=" + order.getOrderNum() + ",payTime=" + order.getPayTime());
//        }
//        //不管是Date、String、Long类型的日期都可以排序，无需转换
//        orders.sort(Comparator.comparing(Order::getPayTime));
//        System.out.println("------------倒序后-----------------");
//        for (Order order : orders) {
//            System.out.println("orderNum=" + order.getOrderNum() + ",payTime=" + order.getPayTime());
//        }

//        List<String> list = new ArrayList<>();
//        list.add("2023-06-15");
//      list.forEach(
//              a -> {
//                  if ( a.compareTo("2023-06-09") > 0) {
//                      System.out.println(a);
//                  }
//
//              }
//      );

//
//        String a = null;
//        JSONObject jsonObject = JSON.parseObject(a);
//        String last_stock = jsonObject.getString("lock_stock");
//        System.out.println(last_stock);
//        CalSuggestDataDTO calSuggestDataDTO = new CalSuggestDataDTO();
//        calSuggestDataDTO.setStockAtTransport(Objects.isNull(null) ? null: -1);
//        System.out.println(calSuggestDataDTO);

//        int i = 010;
//        int a = 010 & i;
//        System.out.println(a);
//        List<Person> list = new ArrayList<>();
//        Person one = new Person();
//        Student student = new Student(1, "lisi");
//        assemble(one.getName(), student);
//        Person two = new Person(2, "2");
//        Person three = new Person(3, "3");
//        Map<String, Person> map = new HashMap<>();
//        map.put("1", one);
//        map.put("2", two);
//        Person person = map.get("1");
//        list.add(person);
//        person = map.get("2");
//        list.add(person);
//        System.out.println(list);
//        System.out.println(one);
//        LocalDate now = LocalDate.now();
//        LocalDateTime now2 = LocalDateTime.now();
//        System.out.println(now);
//        System.out.println(now2);
//
//        List<Long> a = new ArrayList<>();
//        List<Long> b = new ArrayList<>();
//        a.add(1L);
//        b.add(1L);
//        a.add(2L);
//        b.add(2L);
//        if (a.equals(b)) {
//            System.out.println("sad");
//        }
        List<List<Person>> list = new ArrayList<>();
        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();
        Person a = new Person(1, "");
        Person b = new Person(1, "");
        Person c = new Person(1, "");
        Person d = new Person(1, "");
        list1.add(a);
        list1.add(b);
        list1.add(c);
        list1.add(d);
        list2.add(a);
        list2.add(b);
        list2.add(c);
        list2.add(d);
        list.add(list1);
        list.add(list2);
        List<Person> collect = list.stream().filter(Objects::nonNull).flatMap(Collection::stream).distinct()
                .collect(Collectors.toList());
        System.out.println(collect);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.withMinute(0).withSecond(0).withNano(0);
        System.out.println(localDateTime);
    }

    private static void assemble(String name, Student student) {
        name = student.getName();
    }
}
