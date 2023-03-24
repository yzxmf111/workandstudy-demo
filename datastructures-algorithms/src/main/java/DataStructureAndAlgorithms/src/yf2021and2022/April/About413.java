/*
package April;


import java.util.ArrayList;
import java.util.List;

public class About413 {

    //1.二叉搜索树中序遍历是有序的,遍历做差
    //2.dfs/bfs添加进list,遍历找最小
    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (root == null) return 0;
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 1; i < list.size(); i++) {
            if ((list.get(i) - list.get(i - 1)) < min) {
                min = list.get(i) - list.get(i - 1);
            }
        }


        return min;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        //可以前中后序遍历,只是中序遍历最佳
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
*/
