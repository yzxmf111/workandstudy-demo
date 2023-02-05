package cn.xiaotian.basejava;

public class Son extends Father {

    public static String staticField = "Son静态变量";

    static {
        System.out.println("Son静态语句块");
    }

    private String field = "Son实例变量";

    {
        System.out.println("Son普通语句块");
    }

    //存在继承关系时的父子类初始化顺序
//父类（静态变量、静态语句块）
//子类（静态变量、静态语句块）
//父类（实例变量、普通语句块）
//父类（构造函数）
//子类（实例变量、普通语句块）
//子类（构造函数）
    public static void main(String[] args) {
        Son son = new Son();
    }

}
