package cn.xiaotian;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-16 17:42
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MainApplication implements ApplicationContextAware {


    /**
     * ApplicationContextAware: 某些bean必须借助容器才能实现某个功能
     * 我们只需要在该bean上实现ApplicationContextAware接口，在容器初始化之后，就会把容器注入进来
     */
    public ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
