package cn.xiaotian.basejava;

public class A {
    static {
        System.out.println("123");
    }

    public static int a = 1;



    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
    }
}