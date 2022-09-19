package cn.xiaotian.observerpattern;

import org.springframework.stereotype.Component;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-16 17:33
 */
@Component
public class ConcreteObservertwo implements Observer{

    @Override
    public boolean update(String msg) {
        System.out.println("ConcreteObserverTwo 更新了信息" + msg);
        return true;
    }


}
