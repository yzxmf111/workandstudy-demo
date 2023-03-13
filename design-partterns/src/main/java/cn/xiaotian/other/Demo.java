package cn.xiaotian.other;

import io.lettuce.core.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-22 10:42
 */
@Component
public class Demo {

    private final Map<String, TokenTask> taskMap;

    @Autowired
    public Demo(Map<String, TokenTask> taskMap) {
        this.taskMap = taskMap;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
    }
}
