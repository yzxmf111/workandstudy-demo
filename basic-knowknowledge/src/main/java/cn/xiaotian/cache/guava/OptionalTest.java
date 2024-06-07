package cn.xiaotian.cache.guava;

import com.google.common.base.Optional;


/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/6/6 17:28
 **/
public class OptionalTest {

    public static void main(String[] args) {
        Integer a = null;
        Integer b = 1;
        // 支持null、非null
        Optional<Integer> optionalA1 = Optional.fromNullable(a);
        Optional<Integer> optionalA2 = Optional.fromNullable(b);
        // 不支持null,参数为null报错
        Optional<Integer> optionalB = Optional.of(b);
        // 不包含引用对象的实例()
        Optional<Integer> optionalC = Optional.absent();

        // 不存在实例，不进入
        if (optionalA1.isPresent()) {
            System.out.println(" A1 get=" + optionalA1.get());
        }
        // 存在实例，进入
        if (optionalA2.isPresent()) {
            System.out.println(" A2 get=" + optionalA2.get());
        }
        // 存在实例，进入
        if (optionalB.isPresent()) {
            System.out.println(" B get=" + optionalB.get());
        }
        // 不存在实例，不进入
        if (optionalC.isPresent()) {
            System.out.println(" C get=" + optionalC.get());
        }

    }
}
