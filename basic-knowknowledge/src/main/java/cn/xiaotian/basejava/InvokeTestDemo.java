package cn.xiaotian.basejava;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/7/27 14:12
 **/
public class InvokeTestDemo {
    public static void main(String[] args) {
        Person person = new Person(10, "zhangsan");
        String name = person.getName();
        name = "lisi";
        System.out.println(person);
    }

}
