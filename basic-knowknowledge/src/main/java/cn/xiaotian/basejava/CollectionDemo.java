package cn.xiaotian.basejava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/7/18 09:48
 **/
public class CollectionDemo {

    public static void main(String[] args) {
//        final List<String> permissions = new ArrayList<>();
//        permissions.add("1");
//        permissions.add("1");
//        permissions.add("1");
//        System.out.println(permissions);
       final List<String> permissions = ImmutableList.of();
        System.out.println(permissions);
    }

}
