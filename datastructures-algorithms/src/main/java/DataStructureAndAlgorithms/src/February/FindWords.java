package February;

/**
 * @description:
 * @author: Tian
 * @time: 2021/2/4 17:36
 */


public class FindWords {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, used, i, j, 0, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] used, int i, int j, int index, int m, int n) {
        //递归的终止条件
        if (i < 0 || j < 0 || i >= m || j >= n || used[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        used[i][j] = true;
        if (dfs(board, word, used, i + 1, j, index + 1, m, n)) {
            return true;
        }
        if (dfs(board, word, used, i - 1, j, index + 1, m, n)) {
            return true;
        }
        if (dfs(board, word, used, i, j + 1, index + 1, m, n)) {
            return true;
        }
        if (dfs(board, word, used, i , j - 1, index + 1, m, n)) {
            return true;
        }
        used[i][j] = false;
        return false;
    }
}
