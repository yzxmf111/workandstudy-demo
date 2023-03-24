package March;

import java.util.*;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/30 10:54
 */


public class About330 {

    /*public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 18}, {20, 25, 26, 27}, {28, 29, 33, 35}};
        About330 ans = new About330();
        boolean b = ans.searchMatrix(arr, 13);
        System.out.println(b);
    }*/

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean ans = false;
        for (int i = 0; i < m; i++) {
            ans = binarySearch(matrix[i], target);
            if (ans) return ans;
        }
        return ans;
    }

    private boolean binarySearch(int[] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }


    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0, len = chars.length;
        while (i < len) {
            if (chars[i] == ' ') {
                i++;
                continue;
            }
            char temp = chars[i];
            if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
                i++;
                while (i < chars.length && chars[i] == ' ') {
                    i++;
                }
            }
            int num = 0;
            while (i < len && Character.isDigit(chars[i])) {
                num = 10 * num + (chars[i] - '0');
                i++;
            }
            switch (temp) {
                case '+': {
                    num = num;
                    break;
                }
                case '-': {
                    num = -num;
                    break;
                }
                case '*': {
                    num = deque.removeLast() * num;
                    break;
                }
                case '/': {
                    num = deque.removeLast() / num;
                    break;
                }
            }
            deque.addLast(num);
        }
        int sum = 0;
        for (Integer m : deque) {
            sum += m;
        }
        return sum;
    }

    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        //private Map<Integer, Integer> map;
        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;

            //开启了访问顺序,访问到的节点会放在链表的后边
            //map = new LinkedHashMap<Integer, Integer>(capacity, (float) 0.75, true);
        }

        public int get(int key) {
            if (super.get(key) != null) return (int) super.get(key);
            else return -1;
        }

        public void put(int key, int val) {
            //要想开启put删除最老的节点, 需要重写一个方法
            //多态的应用--如果子类重写了父类的方法，真正执行的是子类覆盖的方法，如果子类没有覆盖父类的方法，执行的是父类的方法。
            super.put(key, val);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }


    }

    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            if (!set.add(value)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 2, 1, 1, 3};
        About330 ans = new About330();
        boolean b = ans.uniqueOccurrences(a);
        System.out.println(b);
    }
}
