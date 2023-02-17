package cn.xiaotian.basejava;

import java.util.Arrays;

/**
 * 在阿里Java开发手册中，有这么一条建议：慎用 Object 的 clone 方法来拷贝对象。
 * 对象 clone 方法默认是浅拷贝，若想实现深拷贝需覆写 clone 方法实现域对象的深度遍历式拷贝 。
 */

public class ShallowCloneExample implements Cloneable {

    private int[] arr;

    public ShallowCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShallowCloneExample that = (ShallowCloneExample) o;
        return Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }

    @Override
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }

//    @Override
//    public String toString() {
//        return "ShallowCloneExample{" +
//                "arr=" + Arrays.toString(arr) +
//                '}';
//    }

    public static void main(String[] args) {
        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;
        try {
            //浅拷贝--e1!=e2 但是，e1.arr == e2.arr
            //https://juejin.cn/post/6844903903943720967
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(2, 222);
        System.out.println(e2.get(2)); // 222
        System.out.println(e1 == e2);
        System.out.println(e1.arr == e2.arr);
    }
}