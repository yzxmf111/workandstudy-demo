package cn.xiaotian.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-23 16:59
 */
public class BeanFactoryDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring.xml"); //实例化一个Spring容器，
        Object concrete2TokenTask = ac.getBean("concrete2TokenTask");
    }
}
