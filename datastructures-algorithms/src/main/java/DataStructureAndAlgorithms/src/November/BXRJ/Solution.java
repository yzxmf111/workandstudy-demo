package November.BXRJ;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1,3,nums2,3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int len = m + n -1 ;
        while (i >= 0 && j >= 0) {
            nums1[len--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        System.arraycopy(nums2,0,nums1,0,j + 1);

    }
}