package cn.xiaotian.basejava;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
        deque.offerFirst(null);

    }
}