package November.futureuptome;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {4, 2, 5, 7};
        int[] ints = solution.sortArrayByParityII(A);
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int i = 0;
        int j = 1; //负责记录奇数的指针
        while (i < len) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                //交换
                swap(A, i, j);

            }
            i += 2;
        }
        return A;
    }


    private void swap(int[] A, int i, int j) {
        int temp = 0;
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}