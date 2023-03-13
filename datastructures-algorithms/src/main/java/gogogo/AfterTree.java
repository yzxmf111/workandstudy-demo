package gogogo;

import xiaotian.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-27 17:48
 */
public class AfterTree {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root ==null) return list;
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.val);
    }
}
