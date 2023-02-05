package cn.xiaotian.basejava;

public class Father {

    public static String staticField = "father静态变量";

    static {
        System.out.println("father静态语句块");
    }

    private String field = "father实例变量";

    {
        System.out.println("father普通语句块");
    }

    public Father() {
    }

}
