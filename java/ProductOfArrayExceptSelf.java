package com.leetcode.medium;

public class ProductOfArrayExceptSelf {
    
    public int[] productExceptSelf(int[] nums) {
        // 1    2   3   4
        // 1    1   2   6   --> left
        // 24   12  4   1   --> right
        
        if(nums == null || nums.length == 0) { return nums; }
       
        int len = nums.length;
        
        int[] left = new int[len];
        int[] right = new int[len];
        
        left[0] = 1; 
        right[len - 1] = 1;
        
        for(int i = 1; i < len; i++) {
            left[i] = left[i-1]*nums[i - 1];
        }
        
        for(int j = len - 2; j >=0; j--) {
            right[j] = right[j+1]*nums[j + 1];
        }
        
        for(int i = 0; i < len; i++) {
            right[i] = left[i]*right[i];
        }
        
        return right;
       
    }
    
    public static void main(String[] args) {
        ProductOfArrayExceptSelf pae = new ProductOfArrayExceptSelf();
        int[] arr = new int[]{1,2,3,4};
        pae.productExceptSelf(arr);
    }

}
