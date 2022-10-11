package November.day1129;

import java.util.*;

public class RefactoringString {

    public static void main(String[] args) {
        RefactoringString RS = new RefactoringString();
        String aab = RS.reorganizeString("bfrbs");
        System.out.println(aab);
    }

    public String reorganizeString(String S) {
        if (S == null && S.length() < 3) return S;
        char[] chars = S.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }
        //在这里需要判断可以重排
        Set<Character> set = map.keySet();
        for (Character c : set) {
            pq.add(c);
        }
        char ans = pq.poll();
        Integer max = map.get(ans);
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += map.get(pq.poll());
        }
        char[] arr = new char[S.length()];
        if (sum >= max - 1) {
            //在这里进行重排
            for (int i = 0; i < S.length(); i += 2) {
                arr[i] = ans;
            }
            int j = 1;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) != ans) {
                    arr[j] = S.charAt(i);
                    if (j + 2 < S.length())
                        j += 2;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }



}

