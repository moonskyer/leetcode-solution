package com.yzy.leetcode.s6;

import org.junit.Assert;
import org.junit.Test;

public class S063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //初始化
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] arr = new int[n];
        for (int index = 0; index < n; index++) {
            if (index > 0) {
                if (obstacleGrid[0][index] == 1) {
                    arr[index] = 0;
                } else {
                    arr[index] = arr[index - 1];
                }
            } else {
                arr[index] = 1 - obstacleGrid[0][index];
            }

        }

        for (int loop = 1; loop < m; loop++) {
            for (int index = 0; index < n; index++) {
                if (obstacleGrid[loop][index] == 1) {
                    arr[index] = 0;
                } else {
                    arr[index] = arr[index] + (index > 0 ? arr[index - 1] : 0);
                }
            }
        }
        return arr[n - 1];
    }


    @Test
    public void test() {
        Assert.assertEquals(2, uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
