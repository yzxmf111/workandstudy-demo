package cn.xiaotian.basejava;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {
//        Map<String, BigDecimal> operationForecastMap = new HashMap<>();
//        long count = operationForecastMap.values().stream()
//                .filter(value -> 0 != value.compareTo(BigDecimal.ZERO))
//                .count();
//        System.out.println(count);
//
        List<Integer> list = new ArrayList();
        list.add(111);
        list.add(222);
        list.add(222);
        list.add(333);
        list.add(222);
        list.add(555);
        list = list.stream().filter(
                o -> o > 222
        ).collect(Collectors.toList());

        System.out.println(list);
    }

}