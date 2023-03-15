package cn.xiaotian.spring.aop;

import java.lang.annotation.*;

/**
 * 自定义注解作为切点
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
    String desc();
}
