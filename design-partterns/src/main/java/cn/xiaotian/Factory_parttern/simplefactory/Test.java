package cn.xiaotian.Factory_parttern.simplefactory;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-06 19:17
 */
public class Test {

    public static void main(String[] args) {
        FactoryMethod factory = new ConcreteFactoryOne();
        factory.doSomething(factory.getComputer().getName());
    }
}
