package gogogo;


import java.util.*;

/**
 * @author xiaotian
 * @description
 * @date 2022-08-09 15:52
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long a = in.nextLong();
        String s = String.valueOf(a);
        char[] chars = s.toCharArray();
        //int zeroNum = 0;
        //int noZeroNum = 0;
        //for (char aChar : chars) {
        //    if (aChar == '0') {
        //        zeroNum++;
        //    }
        //}
        //noZeroNum = chars.length - zeroNum;
        StringBuilder sb = new StringBuilder();
        //List<Long> list = new ArrayList<>();
        //Long c ;
        //while (a > 0) {
        //     c = a % 10;
        //     if (c != 0) {
        //         list.add(c);
        //     }
        //     a /= 10;
        //}
       //全排列
        boolean flag = false;
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = Integer.parseInt(chars[i] + "");
        }

        List<List<Integer>> permute = permute(ints);
        for (List<Integer> subList : permute) {
            for (Integer subSubList : subList) {
                sb.append(subSubList);
            }
            if (sb.toString().startsWith("0")) {
                continue;
            }
            long l = Long.parseLong(sb.toString());
            sb = new StringBuilder();

            if (l % 375 == 0) {
                System.out.println(l);
                flag = true;
                //break;
            }
        }
        if (! flag) {
            System.out.println(-1);

        }


    }


        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            if (nums == null || nums.length == 0) return list;
            Deque<Integer> path = new ArrayDeque<>();
            int len = nums.length;
            boolean[] b = new boolean[len];
            dfs(0,len,nums,path,b,list);
            return list;
        }

        private static void dfs(int index, int len, int[] nums, Deque<Integer> path, boolean[] b,  List<List<Integer>> list) {
            if (index == len) {
                list.add(new ArrayList<>(path));//进行copy
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!b[i]) { //索引i位置上的数没有使用过,将之对应的数值添加到path中
                    path.addLast(nums[i]);
                    //修改为true
                    b[i] = true;
                    //向下递归
                    dfs(index + 1, len, nums, path, b,list);
                    b[i] = false;
                    path.removeLast();
                }

            }
        }

}
