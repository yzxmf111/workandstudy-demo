package December.LeetCode;

/**
 * 79.单词搜索
 */
public class Solution {

    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int n;
    private boolean[][] marked;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, board, word, 0, marked)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int index, boolean[][] marked) {
        if (i < 0 || j < 0 || i >= m || j >= n || marked[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        marked[i][j] = true;
        if (dfs(i + 1, j, board, word, index + 1, marked)) {
            return true;
        }
        if (dfs(i, j + 1, board, word, index + 1, marked)) {
            return true;
        }
        if (dfs(i - 1, j, board, word, index + 1, marked)) {
            return true;
        }
        if (dfs(i, j - 1, board, word, index + 1, marked)) {
            return true;
        }

        //如果都不行就状态重置
        marked[i][j] = false;
        return false;
    }

    public static void main(String[] args) {

//        char[][] board =
//                {
//                        {'A', 'B', 'C', 'E'},
//                        {'S', 'F', 'C', 'S'},
//                        {'A', 'D', 'E', 'E'}
//                };
//
//        String word = "ABCCED";


        char[][] board = {{'a', 'b'}};
        String word = "ba";
        Solution solution = new Solution();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
}

