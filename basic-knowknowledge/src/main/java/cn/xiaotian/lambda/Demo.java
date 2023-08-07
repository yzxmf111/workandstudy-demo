package cn.xiaotian.lambda;

import io.swagger.models.auth.In;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/7/27 10:18
 **/
public class Demo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> activitys = Arrays.asList("Alice", "Bob", "Charlie", "David");

        IntStream.range(0, names.size())
                .forEach(i -> System.out.println("name=" + activitys.get(i)));

        Integer[][] twoDimentionArray = new Integer[19][7];
        if (Objects.isNull(twoDimentionArray)) {
            System.out.println("可判断");
        } else {
            System.out.println("不可");
        }


    }
}
