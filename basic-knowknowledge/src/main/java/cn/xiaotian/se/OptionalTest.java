package cn.xiaotian.se;

import cn.xiaotian.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author xiaotian
 * @description Optional
 * @date 2023-03-09 11:11
 */
public class OptionalTest {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(18);
        Optional<Object> o = Optional.of(user);
        if (o.isPresent()) {
            System.out.println(o.get());
        }
        Optional.ofNullable(user).orElse(new User());
        System.out.println(user);

        Map<String, String> a = new HashMap<>();
        Map<String, String> b = new HashMap<>();
        a.put("1","1111");
        a.put("2","2222");
        a.put("3","3333");
        a.put("4","4444");
        a.put("5","5555");

        b.put("1","1111");
        b.put("2","2222");
        b.put("3","3333");
        b.put("4","4444");
        b.put("5","5555");
        b.put("6","6666");


     }
}
