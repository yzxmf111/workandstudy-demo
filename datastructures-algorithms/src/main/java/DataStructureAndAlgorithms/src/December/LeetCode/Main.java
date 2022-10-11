package December.LeetCode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int count=0;
            for (int i = 0; i < N; i++) {
                int num = scanner.nextInt();
                if (!map.containsKey(num)) {
                    count = 1;
                    map.put(num, count);
                } else {
                    count = 1 + map.get(num);
                    map.put(num, count);
                }
            }
            //出现最多次数的数
            int length = map.entrySet().size();
            int[] arr = new int[length];
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            ArrayList<Integer> values = new ArrayList<>();

            Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
            if (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();
                values.add(next.getValue());
            }
            Object[] valuesArr = values.toArray();

            System.out.println(Arrays.toString(valuesArr));

            Arrays.sort(valuesArr);
            int max = (int) valuesArr[valuesArr.length - 1];
            //找出key;
            ArrayList<Integer> list = new ArrayList<>();

            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue()==max) {
                    //把所有众数放进一个list
                    list.add(entry.getKey());
                }
            }
            Object[] zhongshuArr = list.toArray();
            //给众数数组排序  0123
            Arrays.sort(zhongshuArr);
            int zhongwei=0;
            if (zhongshuArr.length % 2 != 0) {
                zhongwei = (int) zhongshuArr[(zhongshuArr.length - 1) / 2];
            } else {
                zhongwei = ((int)zhongshuArr[zhongshuArr.length / 2] +
                        (int) zhongshuArr[zhongshuArr.length / 2 - 1]) / 2;
            }
            System.out.println(zhongwei);
        }
    }
}