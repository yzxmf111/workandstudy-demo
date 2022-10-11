package November.JXJR;


public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] M = {{1,1,0,1},{1,1,1,1},{0,1,1,1},{1,0,1,1}};
        int m = solution.findFriendNum(M);
        System.out.println(m);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 寻找朋友总数
     * @param M int整型二维数组
     * @return int整型
     */
    public int findFriendNum(int[][] M) {
        // write code here
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int sum = 0;
        for (int i = 0; i < M.length - 1; i++) {
            for (int j = 0; j < M[i].length -1 ; j++) {
                if (i != j && M[i][j] == 1  && M[i][j+1]==0) {
                    sum += 1;
                }
            }
        }
        return sum;
    }
}