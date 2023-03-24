package November.practice01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        Main solution = new Main();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }


    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        List<Character> list = new ArrayList<>();
        int k = 0, h = 0,max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j< arr.length;j++) {
                if (list.contains(arr[i])) {
                    break;
                }else {
                    list.add(arr[i]);
                }
            }
            max = Math.max(max,list.size());
            //清空
            list.clear();
        }
        return max;
    }
}

