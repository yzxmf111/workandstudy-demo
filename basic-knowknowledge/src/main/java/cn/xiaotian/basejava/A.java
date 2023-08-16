package cn.xiaotian.basejava;

import java.math.BigDecimal;
import java.util.*;

public class A {
    public static void main(String[] args) {
        Map<String, BigDecimal> operationForecastMap = new HashMap<>();
        long count = operationForecastMap.values().stream()
                .filter(value -> 0 != value.compareTo(BigDecimal.ZERO))
                .count();
        System.out.println(count);
    }
}