package com.leetcode.medium;

import java.util.Arrays;

public class PerfectSquare {

    public static void main(String[] args) {
       PerfectSquare ps = new PerfectSquare();
       System.out.println(ps.numSquares(1));
       System.out.println(ps.numSquares(2));
       System.out.println(ps.numSquares(3));
       System.out.println(ps.numSquares(4));
       System.out.println(ps.numSquares(5));
    }
    
    public int numSquares(int n) {
        // Edge cases
        if (n == 0) return 0;
        if (n == 1) { return 1; }
        
        // The dp array.
        int[] dp = new int[n + 1];
        
        // Fill the array with max value.
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // For the squares.
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++) {
            int j = 1;
            int min = Integer.MAX_VALUE;
            while( i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                j++;
            }
            
            dp[i] = min;
        }
        
        return dp[n];
    }

}
