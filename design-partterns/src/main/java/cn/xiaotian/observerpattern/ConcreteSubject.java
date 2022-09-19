package cn.xiaotian.observerpattern;

import cn.xiaotian.MainApplication;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-16 17:37
 */
@Component
public class ConcreteSubject implements Subject, InitializingBean, ApplicationContextAware {

    private static final Map<String, Observer> observerMap = new ConcurrentHashMap<>();

    @Autowired
    private MainApplication mainApplication;

    ApplicationContext applicationContext;

    @Override
    public void register(Observer observer) {
        observerMap.put(observer.getClass().getName(), observer);
    }

    @Override
    public boolean remove(Observer observer) {
        observerMap.remove(observer.getClass().getName());
        return true;
    }

    @Override
    public boolean publish(String message) {
        observerMap.values().forEach(observer -> observer.update(message));
        return true;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Observer> beansOfType = applicationContext.getBeansOfType(Observer.class);
        beansOfType.forEach((k, v) -> register(v));
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
