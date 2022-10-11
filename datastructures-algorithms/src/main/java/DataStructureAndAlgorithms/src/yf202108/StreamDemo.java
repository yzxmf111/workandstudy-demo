package yf202108;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Stream的常用api
 * 概念:
 * 1.什么是stream?
 *   Stream（流）是一个来自数据源的元素队列，它可以支持聚合操作。
 *   数据源：(集合就是数据源)流的数据来源，构造Stream对象的数据源，比如通过一个List来构造Stream对象，这个List就是数据源；
 *   聚合操作：对Stream对象进行处理后使得Stream对象返回指定规则数据的操作称之为聚合操作，比如filter、map、limit、sorted等都是聚合操作。
 */
public class StreamDemo {

    public static void main(String[] args) {

        List<User> list = new ArrayList<>();
        list.add(new User("xiaotian",15));
        list.add(new User("xiaowang",14));
        List<User> collect = list.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        System.out.println(collect.stream().toArray());

        Map<Object, Object> collect1 = list.stream().collect(Collectors.toMap(t -> t.getName(), t -> t));
        System.out.println(collect1.get("xiaotian").toString());

    }

    static class User {
        private String name;
        private Integer age;


        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
