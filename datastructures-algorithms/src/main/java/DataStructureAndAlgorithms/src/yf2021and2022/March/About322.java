package March;

import November.LH.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class About322 {

    //mark:1
    int[] preorder;
    int[] inorder;
    int start = 0;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
         map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //mark: 2 left , right
        TreeNode root = helper(0,preorder.length - 1);
        return root;
    }

    private TreeNode helper( int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[start++];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = helper(0 ,rootIndex - 1);
        root.right = helper(rootIndex + 1, right);
        return root;
    }

    public boolean isPalindrome(int x) {
        String s = "" +  x;
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        if (s.equals(s1)) return true;
        return false;
    }

    public static void main(String[] args) {
        About322 s = new About322();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = s.trap(height);
        System.out.println(trap);
    }
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while(left <= right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax <= rightMax){
                water += leftMax - height[left];
                left++;
            }else{
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left == right) return;
            list.get(right).next = list.get(left);
            right--;
            if (left == right) return;
        }
        list.get(left).next = null;
    }

}
