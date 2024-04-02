package study2024.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiaotian
 * @description 最小路径和
 * @date 2024-03-31 16:54
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();
        List<Integer> listThree = new ArrayList<>();
        List<Integer> listFour = new ArrayList<>();
        listOne.add(2);
        listTwo.addAll(Arrays.asList(3,4));
        listThree.addAll(Arrays.asList(6,5,7));
        listFour.addAll(Arrays.asList(4,1,8,3));
        list.add(listOne);
        list.add(listTwo);
        list.add(listThree);
        list.add(listFour);
        MinimumTotal minimumTotal = new MinimumTotal();
        int i = minimumTotal.minimumTotal(list);
        System.out.println(i);
    }
}
