package study2024;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: yzxmf
 * @Date: 2024/06/02/17:26
 * @Description:
 */
public class D240602 {

    /**
     * 合并k个升序链表
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     * <p>
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 || lists[0] == null) {
            return null;
        }
        ListNode res = null;
        for (ListNode node : lists) {
            res = mergeTwoLists(res, node);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res = new ListNode(Integer.MIN_VALUE), pre = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if (list1 != null) {
            res.next = list1;
        }
        if (list2 != null) {
            res.next = list2;
        }
        return pre.next;
    }


    public ListNode mergeKListsBest(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode res = divideAndMerge(0, lists.length - 1, lists);
        return res;
    }

    private ListNode divideAndMerge(int left, int right, ListNode[] lists) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftNode = divideAndMerge(left, mid, lists);
        ListNode rightNode = divideAndMerge(mid + 1, right, lists);
        return mergeTwoLists(leftNode, rightNode);
    }


    /**
     * 将一个数组中的各个元素拼接组合，得到数字最大的组合。
     * 如：int[] arr = new int[5] {1, 26, 56, 894, 5648};
     * 拼接组合后最大的数为 894565648261 --> 894 56 5648 26 1 的拼接结构
     * <p>
     * 你想将一个数组中的数字以某种方式拼接成一个最大的数字。
     * 为了实现这一点，可以使用自定义的排序规则：将两个数字拼接在一起比较其大小，而不是直接比较数字的大小。
     * 这种排序方式能够确保组合后的结果最大。
     */
    public static String getArraySortMaxNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String strNum : strNums) {
            stringBuilder.append(strNum);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 26, 56, 894, 5648};
        System.out.println(getArraySortMaxNumber(arr));  // 输出: 894565648261
    }

}
