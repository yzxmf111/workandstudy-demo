package November.BXRJ;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        helper(list);
    }

    private static void helper(List<Integer> list) {
        int max = list.get(0), subMax = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (subMax < 0) {
                subMax = list.get(i);
            } else {
                subMax = subMax + list.get(i);
            }
            max = Math.max(max,subMax);
        }
        System.out.println(max);

    }


}
