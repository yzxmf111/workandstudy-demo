package March;

import java.util.Arrays;

public class About321 {
    /**
     * 矩阵的转置 我们尽量使用O(1)的空间复杂度--就是在原数组上进行操作
     *
     * @param matrix
     */


    public static void main(String[] args) {
        About321 about321 = new About321();
        int[][] arr = {{1,0}};
        about321.setZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void setZeroes(int[][] matrix) {

        boolean rowh = false, rowl = false;
        int m = matrix.length, n = matrix[0].length;
        //行和列单独处理
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                rowh = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowl = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (rowh) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (rowl) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
