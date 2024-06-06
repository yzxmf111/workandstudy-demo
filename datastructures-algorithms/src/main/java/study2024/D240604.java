package study2024;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/6/4 15:45
 **/
public class D240604 {

    /**
     * 前k个高频元素
     * @param nums
     * @param k
     * @return
     */
    public static int[] topK(int[] nums, int k) {
        if (nums == null || nums.length <= k) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>(
            (o1, o2) -> map.get(o1) - map.get(o2)
        );
        int j = 0;
        Set<Integer> set = map.keySet();
        for (Integer num : set) {
            if (j < k) {
                pq.offer(num);
                j++;
            } else {
                Integer compareNum = pq.peek();
                if (map.get(compareNum) < map.get(num)) {
                    pq.remove();
                    pq.offer(num);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.remove();
        }
        return res;
    }

    /**
     * 1 <= preorder.length <= 3000
     * inorder.length == preorder.length
     * -3000 <= preorder[i], inorder[i] <= 3000
     * preorder 和 inorder 均 无重复 元素
     * inorder 均出现在 preorder
     * preorder 保证 为二叉树的前序遍历序列
     * inorder 保证 为二叉树的中序遍历序列
     * eg:
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     *
     * 分治：分到不可再分为止
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return divideAndMerge(map, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode divideAndMerge(Map<Integer, Integer> map, int[] preorder, int[] inorder, int preLeft, int preRight,
        int inorderLeft, int inorderRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inorderIndex = map.get(preorder[preLeft]);
        int diff = inorderIndex - inorderLeft;
        root.left = divideAndMerge(map, preorder, inorder, preLeft + 1, preLeft + diff, inorderLeft, inorderIndex - 1);
        root.right = divideAndMerge(map, preorder, inorder, preLeft + 1 + diff, preRight, inorderIndex + 1,
            inorderRight);
        return root;
    }
}
