package cn.xiaotian.basejava;


/**
 * 泛型 ：作用：1、编译期检查
 * @param <T>
 */
public class TKDemo<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        TKDemo a =  new TKDemo();
        //
        a.setT(new ShallowCloneExample());

    }
}
