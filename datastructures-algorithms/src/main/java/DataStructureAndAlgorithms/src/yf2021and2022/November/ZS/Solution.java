package November.ZS;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] ints = solution.relativeSortArray(arr1, arr2);
        String s = Arrays.toString(ints);
        System.out.println(s);

    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //计数排序
        int max = arr1[0];
        for(Integer i : arr1){
            if(max < i) max = i;
        }
        int[] nums = new int[max + 1];
        for (Integer i : arr1) {
            nums[i]++;
        }
        int m = 0;
        for (Integer i : arr2) {
            while (nums[i] > 0) {
                arr1[m++] = i;
                nums[i]--;
            }
        }
        //处理其他
        int n = m;
        for (int j = 0; j < nums.length; j++) {
            while (nums[j] > 0) {
                arr1[n++] = j;
                nums[j]--;
            }
        }
        Arrays.sort(arr1,m,arr1.length);
        return arr1;
    }
}

