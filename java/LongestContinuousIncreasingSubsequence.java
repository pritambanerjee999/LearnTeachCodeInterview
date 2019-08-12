package com.leetcode.medium;

public class LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence lcs = 
                new LongestContinuousIncreasingSubsequence();
        
        int[] test1 = {12, 14, 18, 19, 5};
        int[] test2 = {3, 4, 5, 1, 78, 79, 80, 90};
        int[] test3 = null;
        int[] test4 = new int[0];
        
        int result1 = lcs.findLengthOfLCIS(test1);
        int result2 = lcs.findLengthOfLCIS(test2);
        int result3 = lcs.findLengthOfLCIS(test3);
        int result4 = lcs.findLengthOfLCIS(test4);
        
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
    
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null) { return 0;}
        if (nums.length == 0) { return 0; }
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 1;
            while (i < (nums.length - 1) && nums[i] < nums[i + 1]) {
                i++;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
