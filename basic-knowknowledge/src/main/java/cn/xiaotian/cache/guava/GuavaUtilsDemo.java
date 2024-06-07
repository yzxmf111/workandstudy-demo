package cn.xiaotian.cache.guava;

import com.google.common.base.Optional;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/6/6 13:45
 **/
public class GuavaUtilsDemo {

    /**
     * @Description Optional:一个指向值对象引用的对象实例，使得构造对象时就明确申明是否支持null
     * @author denny
     * @date 2018/7/24 下午2:23
     */
    public static void main(String[] args) {

        /**
         * Optional<T>:一个指向值对象引用的对象实例，使得构造对象时就明确申明是否支持null
         */
        Integer a = null;
        Integer b = 1;
        // 支持null、非null
        Optional<Integer> optionalA1 = Optional.fromNullable(a);
        Optional<Integer> optionalA2 = Optional.fromNullable(b);
        // 不支持null,参数为null报错
        Optional<Integer> optionalB = Optional.of(b);
//        Optional<Integer> optionalBNull = Optional.of(a);
        // 不包含引用对象的实例()
        Optional<Integer> optionalC = Optional.absent();

        // 不存在实例，不进入
        if(optionalA1.isPresent()){
            System.out.println(" A1 get="+optionalA1.get());
        }
        // 存在实例，进入
        if(optionalA2.isPresent()){
            System.out.println(" A2 get="+optionalA2.get());
        }
        // 存在实例，进入
        if(optionalB.isPresent()){
            System.out.println(" B get="+optionalB.get());
        }
        // 不存在实例，不进入
//        if(optionalBNull.isPresent()){
//            System.out.println(" B get="+optionalBNull.get());
//        }
        // 不存在实例，不进入
        if(optionalC.isPresent()){
            System.out.println(" C get="+optionalC.get());
        }

        /**
         * Preconditions:前置条件校验，让方法中的条件检查更简单。
         */

    }
}
