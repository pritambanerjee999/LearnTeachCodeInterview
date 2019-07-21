package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
}

public class InOrderBinaryTreeTraversal {
    
    public List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        // stack.push(current);

        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            list.add(current.val);
            current = current.right;
        }

        return list;
    }
}
