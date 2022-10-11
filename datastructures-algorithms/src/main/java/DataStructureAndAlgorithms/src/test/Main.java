package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        List<String> list = new ArrayList<>();
        int j =0;
        while (j < arr[0]) {
            String[] s1 = bf.readLine().split(" ");
            list.add(s1[0]);
            map.put(s1[0], Integer.valueOf(s1[1]));
            if (count == 0) sum += map.get(s1[0]);
            count++;
            j++;
        }
        int[] ans = new int[map.size()];
        int m = 0;
        for (String s1 : map.keySet()) {
            ans[m++] = map.get(s1);
        }
        int c = 0;
        int max = 0;
        String e = "0";
        for (String s1 : list) {
            if (Integer.valueOf(s1) <= arr[1] && c < arr[2]) {
                if (map.get(s1) > max) {
                    max = map.get(s1);
                    e = s1;
                }

            }
        }
        sum += max;
        max = 0;
        for (String s1 : list) {
            if (Integer.valueOf(s1) - Integer.valueOf(e)  <= arr[1] && c < arr[2]) {
                if (map.get(s1) > max) max = map.get(s1);
            }
        }
        sum += max;
        System.out.println(sum);
    }
}