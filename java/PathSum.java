package com.leetcode.bst;

public class PathSum {
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) { return false;}
        return checkSum(root, sum);
    }
    
    public boolean checkSum(TreeNode root, int left) {
        if(root == null && left == 0) { return true; } 
        if(root == null ) { return false; }
        System.out.println("left = " + left);
        if(root.left == null && root.right == null) {
            left = left - root.val;
            if(left == 0) {
                return true;
            }
            
            return false; 
        }
        
        boolean l = false;
        boolean r = false;
        
        if(root.left != null) {
            l = checkSum(root.left, left - root.val);
        }
        
        if(root.right != null) {
            r = checkSum(root.right, left - root.val);
        }
        
        
        boolean ans = r || l ;
        
        return ans;
    }

}
