package cn.xiaotian.Factory_parttern.factorymethod_parttern;

/**
 * @author xiaotian
 * @description
 * @date 2022-10-31 16:27
 */
public interface Transport {

    void deliver();

    default void feifei() {
        System.out.println();
    }

    void func1();

    default void func2(){
        System.out.println("func2");
    }

    int x = 123;
    // int y;               // Variable 'y' might not have been initialized
//    public int z = 0;       // Modifier 'public' is redundant for interface fields
    // private int k = 0;   // Modifier 'private' not allowed here
    // protected int l = 0; // Modifier 'protected' not allowed here
    // private void fun3(); // Modifier 'private' not allowed here
}
