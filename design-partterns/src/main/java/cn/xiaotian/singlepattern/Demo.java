package cn.xiaotian.singlepattern;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-01 14:16
 */
public class Demo {

    public static void main(String[] args) {
        Man man = Test.man = new Man();
        man.haveSomeFeature();
    }
}
