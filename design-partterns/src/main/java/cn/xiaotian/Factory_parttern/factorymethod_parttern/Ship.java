package cn.xiaotian.Factory_parttern.factorymethod_parttern;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xiaotian
 * @description
 * @date 2022-10-31 17:16
 */
@Component("ship")
public class Ship extends TransportTool implements Transport{

    @PostConstruct
    private void init() {
        TransportUtils.addTools(new Ship());
    }

    @Override
    public void deliver() {
        System.out.println("我用船只运输，我要浪");
    }

    @Override
    public Transport createTransportTool() {
        return new Ship();
    }
}
