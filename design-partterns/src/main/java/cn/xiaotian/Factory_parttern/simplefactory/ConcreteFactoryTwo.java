package cn.xiaotian.Factory_parttern.simplefactory;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-06 17:45
 */
public class ConcreteFactoryTwo implements FactoryMethod{


    @Override
    public Computer getComputer() {
        return new Mac();
    }


}
