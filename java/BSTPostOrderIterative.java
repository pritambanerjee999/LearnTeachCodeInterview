package com.leetcode.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BSTPostOrderIterative {

    public List<Integer> postorderTraversal(TreeNode root) {

        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return ans;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
