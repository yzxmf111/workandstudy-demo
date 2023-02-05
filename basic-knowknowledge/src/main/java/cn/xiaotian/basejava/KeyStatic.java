package cn.xiaotian.basejava;

public abstract class KeyStatic {
    //        静态方法不依赖与任何实例，那就必须有实现，不能是抽象的
    public /*abstract*/ static void func1() {
    }

    private static int x;
    private int y;

    //只能访问所属类的静态字段和静态方法，方法中不能有 this 和 super 关键字，因为这两个关键字与具体对象关联。
    public static void func2() {
        int a = x;
//         int b = y;  // Non-static field 'y' cannot be referenced from a static context
//         int b = this.y;     // 'A.this' cannot be referenced from a static context
    }
}
