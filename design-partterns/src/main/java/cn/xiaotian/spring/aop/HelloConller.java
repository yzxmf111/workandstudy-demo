package cn.xiaotian.spring.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaotian
 * @description
 * @date 2023-03-14 14:37
 */
@RestController
public class HelloConller {

    @GetMapping("/hello")
    @WebLog(desc = "这是一个欢迎接口")
    public String hello(String name){
        return "Hello "+name;
    }

}
