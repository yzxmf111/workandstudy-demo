package cn.xiaotian.basejava;

import java.util.*;

public class A {
    static {
        System.out.println("123");
    }

    public static int a = 1;



    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();

        Deque<A> queue = new LinkedList<>();
        Deque<A> deque = new ArrayDeque<>();
        queue.offerFirst(null);
        //deque.offerFirst(null);


        List<String> strings = Arrays.asList("1", "2");
        strings.add("3");
        System.out.println(strings);

    }
}