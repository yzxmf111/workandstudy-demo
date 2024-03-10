package cn.xiaotian.collection;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/7/21 10:38
 **/
public class Sum {


    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5");
        a.forEach(
                o -> {
                    if (StringUtils.equals(o, "1")) {
                        return;
                    }
                    System.out.println(o);
                }
        );
    }

}
