package cn.xiaotian.se;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String singleChar = sc.nextLine();
        String targetStr = sc.nextLine();
        if (!targetStr.contains(singleChar)) {
            int res = calLength(targetStr);
            System.out.println(res);
        } else {
            int res = calLengthTwo(singleChar, targetStr);
            System.out.println(res);
        }
    }

    private static int calLengthTwo(String singleChar, String targetStr) {
        int max = 0;
        char[] chars = targetStr.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (singleChar.equals(chars[i] + "")) {
                list.add(i);
            }
        }
        List<String> req = new ArrayList<>();
        if (list.size() == 1) {
            System.out.println(targetStr.substring(0, list.get(0)));
        }
        req.add(targetStr.substring(0, list.get(0)));
        for (int i = 1; i < list.size(); i++) {
            req.add(targetStr.substring(list.get(0) + 1, list.get(i)));
        }
        for (int i = 0; i < req.size(); i++) {
            max = Math.max(max, calLength(req.get(i)));
        }
        return max;
    }

    private static int calLength(String targetStr) {
        int j = 0, max = 0;
        Map<Character, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < targetStr.length(); i++) {
            if (map.containsKey(targetStr.charAt(i))) {
                Map<Integer, Integer> integerIntegerMap = map.get(targetStr.charAt(i));
                if (integerIntegerMap.values().size() == 2) {
                    Integer integer = map.get(targetStr.charAt(i)).get(1);
                    j = integer+1;
                } else {
                    integerIntegerMap.put(2, i);
                    map.put(targetStr.charAt(i), integerIntegerMap);
                }

            } else {
                Map<Integer, Integer> subMap = new HashMap<>();
                subMap.put(1, i);
                map.put(targetStr.charAt(i), subMap);
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}