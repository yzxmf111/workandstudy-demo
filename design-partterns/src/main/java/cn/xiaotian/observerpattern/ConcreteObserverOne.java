package cn.xiaotian.observerpattern;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-16 17:33
 */

import org.springframework.stereotype.Component;

@Component
public class ConcreteObserverOne implements Observer{
    @Override
    public boolean update(String msg) {
        System.out.println("ConcreteObserverOne 更新了信息" + msg);
        return true;
    }
}
