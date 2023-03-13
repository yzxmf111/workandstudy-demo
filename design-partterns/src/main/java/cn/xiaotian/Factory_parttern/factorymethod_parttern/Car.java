package cn.xiaotian.Factory_parttern.factorymethod_parttern;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xiaotian
 * @description
 * @date 2022-10-31 17:16
 */
@Component("car")
public class Car extends TransportTool implements Transport{

    @PostConstruct
    private void init() {
        TransportUtils.addTools(new Car());
    }

    @Override
    public void deliver() {
        System.out.println("我用汽车运输我开心😄");
    }

    @Override
    public void feifei() {

    }

    @Override
    public void func1() {

    }

    @Override
    public void func2() {

    }

    @Override
    public Transport createTransportTool() {
        return new Car();
    }
}
