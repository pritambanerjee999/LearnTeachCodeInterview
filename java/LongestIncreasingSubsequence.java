package com.leetcode.medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /**
     *  Test the code.
     *  
     * @param args
     */
    public static void main(String[] args) {
        int[] test1 = {12, 14, 18, 19, 5};
        int[] test2 = {3, 4, 5, 1, 78, 79, 80, 90};
        int[] test3 = null;
        int[] test4 = new int[0];
        
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        
        System.out.println(lis.lengthOfLIS(test1));
        System.out.println(lis.lengthOfLIS(test2));
        System.out.println(lis.lengthOfLIS(test3));
        System.out.println(lis.lengthOfLIS(test4));
        
    }

    /**
     * Length Of Longest Increasing Subsequence
     * 
     * @param nums Arrays
     * @return Returns the length of the maximum sequence
     */
    public int lengthOfLIS(int[] nums) {
        if(nums == null) { return 0; }
        if (nums.length == 0) { return 0; }

        int[] dp = new int[nums.length];

        int len = 0;

        for (int n : nums) {

            // Find the position of it in binary tree.
            int pos = Arrays.binarySearch(dp, 0, len, n);

            // Convert the negative position to positive.
            if (pos < 0) {
                pos = -1 * (pos + 1);
            }

            // assign the value to n
            dp[pos] = n;

            // If the length of the dp grows and becomes equal to the current len
            // assign the output length to that.
            if (pos == len) {
                len++;
            }
        }

        // Return the length.
        return len;
    }
}
