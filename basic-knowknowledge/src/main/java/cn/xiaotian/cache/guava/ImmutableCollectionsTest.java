package cn.xiaotian.cache.guava;

import com.google.common.collect.ImmutableSet;

/**
 * @Author yifan.tian
 * @Description 用不变的集合进行防御性编程和性能提升。
 * @Date 2024/6/7 10:21
 **/
public class ImmutableCollectionsTest {
    /**
     * 1.直接申明静态集合
     */
    public static final ImmutableSet<String> COLOR_NAMES_1 = ImmutableSet.of(
        "red",
        "orange",
        "yellow",
        "green");
    /**
     * 2.防御式copy
     */
    public static final ImmutableSet<String> COLOR_NAMES_2 = ImmutableSet.copyOf(COLOR_NAMES_1);

    /**
     * 3.builder建造者模式
     */
    public static final ImmutableSet<String> COLOR_NAMES_3 = ImmutableSet.<String>builder().addAll(COLOR_NAMES_2).add("blue").build();


    public static void main(String[] args) {
        System.out.println("of："+COLOR_NAMES_1);
        System.out.println("防御式copy："+COLOR_NAMES_2);
        System.out.println("建造者模式："+COLOR_NAMES_3);
        System.out.println("转换成list："+COLOR_NAMES_3.asList());

        ImmutableSet<String> res = ImmutableSet.of(
            "red",
            "orange",
            "yellow",
            "green");
        res.add("redre");


    }

}