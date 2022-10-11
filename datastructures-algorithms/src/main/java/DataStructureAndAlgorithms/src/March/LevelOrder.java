package March;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/1 16:07
 */


public class LevelOrder {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(3);
        TreeNode two = new TreeNode(9);
        TreeNode three = new TreeNode(20);
        TreeNode four = new TreeNode(15);
        TreeNode five = new TreeNode(7);
        one.left = two;
        one.right = three;
        three.left = four;
        three.right = five;
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> lists = levelOrder.levelOrder(one);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(deque.size() > 0) {
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            while(size > 0) {
                TreeNode node = deque.poll();
                size--;
                temp.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            list.add(temp);
        }
        return list;
    }
}
