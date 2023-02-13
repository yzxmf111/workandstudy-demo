package cn.xiaotian.basejava;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-13 10:12
 */
public class TestValueTransfer {

    public void methodA(){
        int a = 10;
        //数字装箱后作为对象进行值传递
        int b = methodB(a);

        System.out.println("a="+ a + "  b="+b);
    }

    private int methodB(int a) {
        //改变了对象的引用，对源对象无影响
        return ++a;
    }

    public static void main(String[] args) {
        TestValueTransfer testValueTransfer = new TestValueTransfer();
        testValueTransfer.methodA();
        Map<String, Integer> map = new HashMap<>();
        map.put(null, 1);
        map.put(null, 2);
        System.out.println(map.get(null));
    }
}
