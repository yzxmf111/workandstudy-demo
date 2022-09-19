package cn.xiaotian.observerpattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-16 18:07
 */
@Component
public class Test {

    @Autowired
    private Subject subject;

    @PostConstruct
    public void executor() {
        // 被观察者触发事件, 通知所有观察者
        subject.publish("阿祖有行动！");
    }
}
