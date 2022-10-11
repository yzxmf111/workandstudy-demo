package November.future;


import java.util.Arrays;

//子字符串第一次出现的位置
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1,3,nums2,3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, t = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[t] = nums1[i];
                i++;
                t++;
            } else {
                temp[t] = nums2[j];
                j++;
                t++;
            }
        }
        //继续赋值
        while (i < m) {
            temp[t] = nums1[i];
            i++;
            t++;
        }
        while (j < m) {
            temp[t] = nums2[j];
            j++;
            t++;
        }
        System.out.println(Arrays.toString(temp));
        //return temp;
    }
}
