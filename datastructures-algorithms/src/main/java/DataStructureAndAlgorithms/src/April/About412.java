package April;

import java.util.Arrays;

public class About412 {

    /**
     * 0全部移到字符串的后边去
     *
     * @param nums
     * @return public String largestNumber(int[] nums) {
     * StringBuilder sb1 = new StringBuilder();
     * StringBuilder sb2 = new StringBuilder();
     * for (int i = 0; i < nums.length; i++) {
     * sb1.append(nums[i]).append(" ");
     * }
     * char[] chars = sb1.toString().toCharArray();
     * Arrays.sort(chars);
     * for (int i = chars.length - 1; i >= 0; i--) {
     * sb2.append(chars[i]);
     * }
     * return sb2.toString();
     * }
     */
    public static void main(String[] args) {
        About412 about412 = new About412();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        //       String s = about412.largestNumber(arr);
//        String s1 = "230";
//        String s2 = "231";
//        String[] s = {s1,s2};
//        Arrays.sort(s,(i1,i2) ->{
//            return (i1+i2).compareTo(i2+i1);
//        });
        //int i = s1.compareTo(s2);
        //  System.out.println(Arrays.toString(s));
        int[] ints = about412.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(ints));
    }

    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] s = new String[len];
        for (int i = 0; i < len; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        //string的compareTo方法比较的是ASCII值/字典值, 现在是升序
        Arrays.sort(s, (a, b) -> {
            return (a + b).compareTo(b + a);
        });
        if (s[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(s[i]);
        }


        return sb.toString();
    }


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = arr1[0];
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] > max) max = arr1[i];
        }
        int[] arr = new int[max + 1];
        for (int i = 0; i < arr1.length; i++) {
            arr[arr1[i]]++;
        }
        int m = 0;
        for (int i : arr2) {
            while (arr[i] != 0) {
                arr[i]--;
                arr1[m++] = i;
            }
        }
        //现在处理还没有在arr2中出现的元素
        int n = m;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != 0) {
                arr1[n++] = i;
                arr[i]--;
            }
        }
        Arrays.sort(arr1, m, n);
        return arr1;
    }


}
