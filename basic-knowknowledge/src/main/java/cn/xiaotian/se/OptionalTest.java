package cn.xiaotian.se;

import cn.xiaotian.entity.User;

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
    }
}
