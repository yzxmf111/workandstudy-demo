package March;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/1 17:57
 */


public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(deque.size() > 0) {
            int size = deque.size();
            while(size > 0) {
                TreeNode node = deque.poll();
                size--;

                if (node.left != null ) {
                    if (node.left.val >= node.val) {return false;}
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    if (node.right.val <= node.val) {return false;}
                    deque.addLast(node.right);
                }
            }

        }
        return true;
    }


}
