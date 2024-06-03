package gogogo;



import study2024.TreeNode;

import java.util.*;

/**
 * @author xiaotian
 * @description 二叉树的前中后序遍历        前序遍历： 中左右     中序遍历： 左中右      后序遍历： 左右中
 * @date 2022-11-08 16:48
 */
public class Day1108 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        // 定义一个存放结果的集合
        List list = new ArrayList();
        // 定义待处理节点的栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null) {
            // 因为中序先处理最左节点，父节点也处于待处理阶段，所以不管三七二十一先将节点入栈
            stack.push(p);
            // 获取左节点并判断状态
            if ((p = p.left) == null) {
                // 此时左节点为空，从栈中获取节点
                while (stack.size() > 0) {
                    // 出栈
                    p = stack.pop();
                    // 获取父节点的值
                    list.add(p.val);
                    // 找到右节点
                    if ((p = p.right) != null) break;
                }
            }
        }
        return list;
    }


    //小顶堆--元素入堆，默认从尾部进入，慢慢调整位置 时间复杂度o(logk)
    //元素入堆，默认从尾部进入，慢慢调整位置 时间复杂度o(logk)
    /**
     * methodOne: 暴力排序，取前k个，时间时间复杂度均 >= o(nlogn)
     * methodTwo: 构造大小为k的小顶堆 时间时间复杂度为 o(nlogk) < o(nlogn)
     */
    public static int[] topK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //Arrays.asList(num).stream().collect(Collectors.toMap(
        //
        //))
        for (Integer num : nums) {
            //统计数字出现的次数
            map.put(num, map.getOrDefault(num, 0) + 1);
            //if (map.get(num) == null) {
            //    map.put(num, 1);
            //} else {
            //    map.put(num, map.get(num) + 1)
            //}
        }
        //优先队列的底层是堆，创建的时候默认是小顶堆
        Queue<Integer> pq = new PriorityQueue<>(
                (o1,o2) -> map.get(o1) - map.get(o2)
        );

        int j = 0;
        Set<Integer> set = map.keySet();
        for (Integer num : set) {
            if (j < k) {
                pq.offer(num);
                j++;
            } else {
                Integer top = pq.peek();
                if (map.get(num) > map.get(top)) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        int[] ints = new int[k];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = pq.poll();
        }
        return ints;

    }

    public int[] getLeastNumbers(int[] arr, int k) {

        //正常情况下先考虑边界条件
        if (k == 0 || arr.length == 0) return new int[]{};
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int i = 0;
        while (i < arr.length) {
            if (i < k) {
                pq.offer(arr[i]);
            } else {
                int ans = pq.peek();
                if (ans > arr[i]) {
                    pq.remove();
                    pq.offer(arr[i]);
                }
            }
            i++;
        }
        int[] nums = new int[k];
        for (int j = 0; j < nums.length; j++) {
            nums[j] = pq.remove();
        }
        return nums;
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> resultList = new ArrayList<>();
            if (root == null) return resultList;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (queue.peek() != null) {
                int n = queue.size();
                List<Integer> subList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    TreeNode cur = queue.poll();
                    subList.add(cur.val);
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                resultList.add(subList);
            }
            return resultList;
        }
    }
//时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
//空间复杂度：队列中元素的个数不超过 n 个，故渐进空间复杂度为 O(n)。
}
