package com.leetcode.medium;

public class RotateImage {
    
    public void rotate(int[][] matrix) {
        int s = 0;
        int e = matrix.length - 1;
        
        while(s < e) {
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++;
            e--;
        }
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i+1; j < matrix[i].length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

}
